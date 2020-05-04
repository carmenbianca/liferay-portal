/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.io.exporter;

import com.liferay.dynamic.data.mapping.io.exporter.DDMFormInstanceRecordWriter;
import com.liferay.dynamic.data.mapping.io.exporter.DDMFormInstanceRecordWriterRequest;
import com.liferay.dynamic.data.mapping.io.exporter.DDMFormInstanceRecordWriterResponse;

import java.io.ByteArrayOutputStream;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.osgi.service.component.annotations.Component;

/**
 * @author Leonardo Barros
 */
@Component(
	immediate = true, property = "ddm.form.instance.record.writer.type=xls",
	service = DDMFormInstanceRecordWriter.class
)
public class DDMFormInstanceRecordXLSWriter
	implements DDMFormInstanceRecordWriter {

	@Override
	public DDMFormInstanceRecordWriterResponse write(
			DDMFormInstanceRecordWriterRequest
				ddmFormInstanceRecordWriterRequest)
		throws Exception {

		Map<String, String> ddmFormFieldsLabel =
			ddmFormInstanceRecordWriterRequest.getDDMFormFieldsLabel();

		int rowIndex = 0;

		try (ByteArrayOutputStream byteArrayOutputStream =
				createByteArrayOutputStream();
			Workbook workbook = createWorkbook()) {

			Sheet sheet = workbook.createSheet();

			CellStyle headerCellStyle = createCellStyle(
				workbook, true, "Courier New", (short)14);

			createRow(
				rowIndex++, headerCellStyle, ddmFormFieldsLabel.values(),
				sheet);

			CellStyle rowCellStyle = createCellStyle(
				workbook, false, "Courier New", (short)12);

			List<Map<String, String>> ddmFormFieldsValueList =
				ddmFormInstanceRecordWriterRequest.getDDMFormFieldValues();

			for (Map<String, String> ddmFormFieldsValue :
					ddmFormFieldsValueList) {

				createRow(
					rowIndex++, rowCellStyle, ddmFormFieldsValue.values(),
					sheet);
			}

			workbook.write(byteArrayOutputStream);

			DDMFormInstanceRecordWriterResponse.Builder builder =
				DDMFormInstanceRecordWriterResponse.Builder.newBuilder(
					byteArrayOutputStream.toByteArray());

			return builder.build();
		}
	}

	protected ByteArrayOutputStream createByteArrayOutputStream() {
		return new ByteArrayOutputStream();
	}

	protected CellStyle createCellStyle(
		Workbook workbook, boolean bold, String fontName,
		short heightInPoints) {

		Font font = workbook.createFont();

		font.setBold(bold);
		font.setFontHeightInPoints(heightInPoints);
		font.setFontName(fontName);

		CellStyle style = workbook.createCellStyle();

		style.setFont(font);

		return style;
	}

	protected void createRow(
		int rowIndex, CellStyle cellStyle, Collection<String> values,
		Sheet sheet) {

		Row row = sheet.createRow(rowIndex);

		int cellIndex = 0;

		for (String value : values) {
			Cell cell = row.createCell(cellIndex++, CellType.STRING);

			cell.setCellStyle(cellStyle);
			cell.setCellValue(value);
		}
	}

	protected Workbook createWorkbook() {
		return new HSSFWorkbook();
	}

}