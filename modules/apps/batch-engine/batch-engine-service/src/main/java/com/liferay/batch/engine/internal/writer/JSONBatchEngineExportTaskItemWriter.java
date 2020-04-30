/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.internal.writer;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SequenceWriter;

import java.io.IOException;
import java.io.OutputStream;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Ivica Cardic
 */
public class JSONBatchEngineExportTaskItemWriter
	implements BatchEngineExportTaskItemWriter {

	public JSONBatchEngineExportTaskItemWriter(
			Set<String> allFieldNames, List<String> includeFieldNames,
			OutputStream outputStream)
		throws IOException {

		_outputStream = outputStream;

		ObjectWriter objectWriter = ObjectWriterFactory.getObjectWriter(
			allFieldNames, includeFieldNames);

		_sequenceWriter = objectWriter.writeValuesAsArray(_outputStream);
	}

	@Override
	public void close() throws IOException {
		_sequenceWriter.close();

		_outputStream.close();
	}

	@Override
	public void write(Collection<?> items) throws Exception {
		_sequenceWriter.writeAll(items);
	}

	private final OutputStream _outputStream;
	private final SequenceWriter _sequenceWriter;

}