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
 * The table class for the &quot;EagerBlobEntity&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EagerBlobEntity
 * @generated
 */
public class EagerBlobEntityTable extends BaseTable<EagerBlobEntityTable> {

	public static final EagerBlobEntityTable INSTANCE =
		new EagerBlobEntityTable();

	public final Column<EagerBlobEntityTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EagerBlobEntityTable, Long> eagerBlobEntityId =
		createColumn(
			"eagerBlobEntityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EagerBlobEntityTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EagerBlobEntityTable, Blob> blob = createColumn(
		"blob_", Blob.class, Types.BLOB, Column.FLAG_DEFAULT);

	private EagerBlobEntityTable() {
		super("EagerBlobEntity", EagerBlobEntityTable::new);
	}

}