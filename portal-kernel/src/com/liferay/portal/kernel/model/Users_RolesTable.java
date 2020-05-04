/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Users_Roles&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Role
 * @see User
 * @generated
 */
public class Users_RolesTable extends BaseTable<Users_RolesTable> {

	public static final Users_RolesTable INSTANCE = new Users_RolesTable();

	public final Column<Users_RolesTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<Users_RolesTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<Users_RolesTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private Users_RolesTable() {
		super("Users_Roles", Users_RolesTable::new);
	}

}