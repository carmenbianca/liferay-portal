/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;DDMStorageLink&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DDMStorageLink
 * @generated
 */
public class DDMStorageLinkTable extends BaseTable<DDMStorageLinkTable> {

	public static final DDMStorageLinkTable INSTANCE =
		new DDMStorageLinkTable();

	public final Column<DDMStorageLinkTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<DDMStorageLinkTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DDMStorageLinkTable, Long> storageLinkId = createColumn(
		"storageLinkId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DDMStorageLinkTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DDMStorageLinkTable, Long> classNameId = createColumn(
		"classNameId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DDMStorageLinkTable, Long> classPK = createColumn(
		"classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DDMStorageLinkTable, Long> structureId = createColumn(
		"structureId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DDMStorageLinkTable, Long> structureVersionId =
		createColumn(
			"structureVersionId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	private DDMStorageLinkTable() {
		super("DDMStorageLink", DDMStorageLinkTable::new);
	}

}