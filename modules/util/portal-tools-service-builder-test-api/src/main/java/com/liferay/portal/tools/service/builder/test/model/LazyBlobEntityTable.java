/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Blob;
import java.sql.Types;

/**
 * The table class for the &quot;LazyBlobEntity&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LazyBlobEntity
 * @generated
 */
public class LazyBlobEntityTable extends BaseTable<LazyBlobEntityTable> {

	public static final LazyBlobEntityTable INSTANCE =
		new LazyBlobEntityTable();

	public final Column<LazyBlobEntityTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LazyBlobEntityTable, Long> lazyBlobEntityId =
		createColumn(
			"lazyBlobEntityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LazyBlobEntityTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LazyBlobEntityTable, Blob> blob1 = createColumn(
		"blob1", Blob.class, Types.BLOB, Column.FLAG_DEFAULT);
	public final Column<LazyBlobEntityTable, Blob> blob2 = createColumn(
		"blob2", Blob.class, Types.BLOB, Column.FLAG_DEFAULT);

	private LazyBlobEntityTable() {
		super("LazyBlobEntity", LazyBlobEntityTable::new);
	}

}