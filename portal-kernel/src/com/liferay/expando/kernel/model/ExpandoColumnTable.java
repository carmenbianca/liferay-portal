/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

/**
 * The table class for the &quot;ExpandoColumn&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoColumn
 * @generated
 */
public class ExpandoColumnTable extends BaseTable<ExpandoColumnTable> {

	public static final ExpandoColumnTable INSTANCE = new ExpandoColumnTable();

	public final Column<ExpandoColumnTable, Long> columnId = createColumn(
		"columnId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ExpandoColumnTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExpandoColumnTable, Long> tableId = createColumn(
		"tableId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExpandoColumnTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExpandoColumnTable, Integer> type = createColumn(
		"type_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ExpandoColumnTable, Clob> defaultData = createColumn(
		"defaultData", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ExpandoColumnTable, Clob> typeSettings = createColumn(
		"typeSettings", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private ExpandoColumnTable() {
		super("ExpandoColumn", ExpandoColumnTable::new);
	}

}