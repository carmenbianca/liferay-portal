/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Users_UserGroups&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see User
 * @see UserGroup
 * @generated
 */
public class Users_UserGroupsTable extends BaseTable<Users_UserGroupsTable> {

	public static final Users_UserGroupsTable INSTANCE =
		new Users_UserGroupsTable();

	public final Column<Users_UserGroupsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<Users_UserGroupsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<Users_UserGroupsTable, Long> userGroupId = createColumn(
		"userGroupId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private Users_UserGroupsTable() {
		super("Users_UserGroups", Users_UserGroupsTable::new);
	}

}