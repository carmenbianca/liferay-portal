/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ExpandoTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoTable
 * @generated
 */
public class ExpandoTableTable extends BaseTable<ExpandoTableTable> {

	public static final ExpandoTableTable INSTANCE = new ExpandoTableTable();

	public final Column<ExpandoTableTable, Long> tableId = createColumn(
		"tableId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ExpandoTableTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExpandoTableTable, Long> classNameId = createColumn(
		"classNameId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExpandoTableTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ExpandoTableTable() {
		super("ExpandoTable", ExpandoTableTable::new);
	}

}