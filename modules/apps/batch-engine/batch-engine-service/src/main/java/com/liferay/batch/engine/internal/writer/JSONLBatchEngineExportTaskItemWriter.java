/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.internal.writer;

import com.fasterxml.jackson.databind.ObjectWriter;

import com.liferay.petra.io.unsync.UnsyncPrintWriter;
import com.liferay.petra.string.StringPool;

import java.io.IOException;
import java.io.OutputStream;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Ivica Cardic
 */
public class JSONLBatchEngineExportTaskItemWriter
	implements BatchEngineExportTaskItemWriter {

	public JSONLBatchEngineExportTaskItemWriter(
		Set<String> allFieldNames, List<String> includeFieldNames,
		OutputStream outputStream) {

		_objectWriter = ObjectWriterFactory.getObjectWriter(
			allFieldNames, includeFieldNames);
		_unsyncPrintWriter = new UnsyncPrintWriter(outputStream);
	}

	@Override
	public void close() throws IOException {
		_unsyncPrintWriter.close();
	}

	@Override
	public void write(Collection<?> items) throws Exception {
		for (Object item : items) {
			_unsyncPrintWriter.write(_objectWriter.writeValueAsString(item));
			_unsyncPrintWriter.write(StringPool.NEW_LINE);
		}
	}

	private final ObjectWriter _objectWriter;
	private final UnsyncPrintWriter _unsyncPrintWriter;

}