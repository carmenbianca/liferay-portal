/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DDMDataProviderInstance&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DDMDataProviderInstance
 * @generated
 */
public class DDMDataProviderInstanceTable
	extends BaseTable<DDMDataProviderInstanceTable> {

	public static final DDMDataProviderInstanceTable INSTANCE =
		new DDMDataProviderInstanceTable();

	public final Column<DDMDataProviderInstanceTable, Long> mvccVersion =
		createColumn(
			"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<DDMDataProviderInstanceTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, Long>
		dataProviderInstanceId = createColumn(
			"dataProviderInstanceId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DDMDataProviderInstanceTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, String> name =
		createColumn("name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, Clob> description =
		createColumn(
			"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, Clob> definition =
		createColumn("definition", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<DDMDataProviderInstanceTable, String> type =
		createColumn("type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DDMDataProviderInstanceTable() {
		super("DDMDataProviderInstance", DDMDataProviderInstanceTable::new);
	}

}