/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.internal.command;

import com.liferay.portal.tools.data.partitioning.sql.builder.exporter.DBExporter;
import com.liferay.portal.tools.data.partitioning.sql.builder.exporter.context.ExportContext;

import java.io.OutputStream;

import java.util.List;

/**
 * @author Manuel de la Peña
 */
public class DeleteExportProcessCommand extends BaseExportProcessCommand {

	public DeleteExportProcessCommand(
		long companyId, DBExporter dbExporter, List<String> tableNames,
		ExportContext exportContext) {

		super(companyId, dbExporter, tableNames, exportContext);
	}

	@Override
	protected String getOutputFileName() {
		return exportContext.getSchemaName() + "-" + companyId + "-delete.sql";
	}

	@Override
	protected String getOutputFileName(String tableName) {
		return exportContext.getSchemaName() + "-" + companyId + "-table-" +
			tableName + "-delete.sql";
	}

	@Override
	protected void write(String tableName, OutputStream outputStream) {
		dbExporter.writeDelete(companyId, tableName, outputStream);
	}

}