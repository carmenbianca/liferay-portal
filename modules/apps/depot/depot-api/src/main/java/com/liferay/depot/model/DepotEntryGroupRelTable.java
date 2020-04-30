/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;DepotEntryGroupRel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DepotEntryGroupRel
 * @generated
 */
public class DepotEntryGroupRelTable
	extends BaseTable<DepotEntryGroupRelTable> {

	public static final DepotEntryGroupRelTable INSTANCE =
		new DepotEntryGroupRelTable();

	public final Column<DepotEntryGroupRelTable, Long> mvccVersion =
		createColumn(
			"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<DepotEntryGroupRelTable, Long> depotEntryGroupRelId =
		createColumn(
			"depotEntryGroupRelId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DepotEntryGroupRelTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepotEntryGroupRelTable, Long> depotEntryId =
		createColumn(
			"depotEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepotEntryGroupRelTable, Boolean> searchable =
		createColumn(
			"searchable", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<DepotEntryGroupRelTable, Long> toGroupId = createColumn(
		"toGroupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DepotEntryGroupRelTable() {
		super("DepotEntryGroupRel", DepotEntryGroupRelTable::new);
	}

}