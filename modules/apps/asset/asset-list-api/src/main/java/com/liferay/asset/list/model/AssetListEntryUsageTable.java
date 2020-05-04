/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AssetListEntryUsage&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AssetListEntryUsage
 * @generated
 */
public class AssetListEntryUsageTable
	extends BaseTable<AssetListEntryUsageTable> {

	public static final AssetListEntryUsageTable INSTANCE =
		new AssetListEntryUsageTable();

	public final Column<AssetListEntryUsageTable, Long> mvccVersion =
		createColumn(
			"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<AssetListEntryUsageTable, Long> ctCollectionId =
		createColumn(
			"ctCollectionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AssetListEntryUsageTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Long> assetListEntryUsageId =
		createColumn(
			"assetListEntryUsageId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AssetListEntryUsageTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Long> assetListEntryId =
		createColumn(
			"assetListEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Long> classNameId =
		createColumn(
			"classNameId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Long> classPK = createColumn(
		"classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, String> portletId =
		createColumn(
			"portletId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssetListEntryUsageTable, Date> lastPublishDate =
		createColumn(
			"lastPublishDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	private AssetListEntryUsageTable() {
		super("AssetListEntryUsage", AssetListEntryUsageTable::new);
	}

}