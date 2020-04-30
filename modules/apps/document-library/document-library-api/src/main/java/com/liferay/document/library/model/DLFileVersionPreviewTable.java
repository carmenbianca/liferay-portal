/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;DLFileVersionPreview&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DLFileVersionPreview
 * @generated
 */
public class DLFileVersionPreviewTable
	extends BaseTable<DLFileVersionPreviewTable> {

	public static final DLFileVersionPreviewTable INSTANCE =
		new DLFileVersionPreviewTable();

	public final Column<DLFileVersionPreviewTable, Long>
		dlFileVersionPreviewId = createColumn(
			"dlFileVersionPreviewId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DLFileVersionPreviewTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DLFileVersionPreviewTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DLFileVersionPreviewTable, Long> fileEntryId =
		createColumn(
			"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DLFileVersionPreviewTable, Long> fileVersionId =
		createColumn(
			"fileVersionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DLFileVersionPreviewTable, Integer> previewStatus =
		createColumn(
			"previewStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private DLFileVersionPreviewTable() {
		super("DLFileVersionPreview", DLFileVersionPreviewTable::new);
	}

}