/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.internal.reader;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Ivica Cardic
 */
public class XLSBatchEngineImportTaskItemReader
	implements BatchEngineImportTaskItemReader {

	public XLSBatchEngineImportTaskItemReader(InputStream inputStream)
		throws IOException {

		_inputStream = inputStream;

		_workbook = new XSSFWorkbook(_inputStream);

		Sheet sheet = _workbook.getSheetAt(0);

		_iterator = sheet.rowIterator();

		Row row = _iterator.next();

		List<String> columnNames = new ArrayList<>();

		for (Cell cell : row) {
			columnNames.add(cell.getStringCellValue());
		}

		_fieldNames = columnNames.toArray(new String[0]);
	}

	@Override
	public void close() throws IOException {
		_inputStream.close();
		_workbook.close();
	}

	@Override
	public Map<String, Object> read() throws Exception {
		if (!_iterator.hasNext()) {
			return null;
		}

		Row row = _iterator.next();

		Map<String, Object> fieldNameValueMap = new HashMap<>();

		int index = 0;

		for (Cell cell : row) {
			String fieldName = _fieldNames[index++];

			if (fieldName == null) {
				continue;
			}

			if (CellType.BOOLEAN == cell.getCellType()) {
				fieldNameValueMap.put(fieldName, cell.getBooleanCellValue());
			}
			else if (CellType.NUMERIC == cell.getCellType()) {
				if (DateUtil.isCellDateFormatted(cell)) {
					fieldNameValueMap.put(fieldName, cell.getDateCellValue());
				}
				else {
					fieldNameValueMap.put(
						fieldName, cell.getNumericCellValue());
				}
			}
			else {
				String value = cell.getStringCellValue();

				value = value.trim();

				if (value.isEmpty()) {
					value = null;
				}

				int lastDelimiterIndex = fieldName.lastIndexOf('_');

				if (lastDelimiterIndex == -1) {
					fieldNameValueMap.put(fieldName, value);
				}
				else {
					BatchEngineImportTaskItemReaderUtil.handleMapField(
						fieldName, fieldNameValueMap, lastDelimiterIndex,
						value);
				}
			}
		}

		return fieldNameValueMap;
	}

	private final String[] _fieldNames;
	private final InputStream _inputStream;
	private final Iterator<Row> _iterator;
	private final Workbook _workbook;

}