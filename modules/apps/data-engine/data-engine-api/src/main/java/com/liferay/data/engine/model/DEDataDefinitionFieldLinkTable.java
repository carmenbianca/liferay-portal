/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DEDataDefinitionFieldLink&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DEDataDefinitionFieldLink
 * @generated
 */
public class DEDataDefinitionFieldLinkTable
	extends BaseTable<DEDataDefinitionFieldLinkTable> {

	public static final DEDataDefinitionFieldLinkTable INSTANCE =
		new DEDataDefinitionFieldLinkTable();

	public final Column<DEDataDefinitionFieldLinkTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, Long>
		deDataDefinitionFieldLinkId = createColumn(
			"deDataDefinitionFieldLinkId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DEDataDefinitionFieldLinkTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, Long> classNameId =
		createColumn(
			"classNameId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, Long> classPK =
		createColumn("classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, Long> ddmStructureId =
		createColumn(
			"ddmStructureId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, String> fieldName =
		createColumn(
			"fieldName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DEDataDefinitionFieldLinkTable, Date> lastPublishDate =
		createColumn(
			"lastPublishDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	private DEDataDefinitionFieldLinkTable() {
		super("DEDataDefinitionFieldLink", DEDataDefinitionFieldLinkTable::new);
	}

}