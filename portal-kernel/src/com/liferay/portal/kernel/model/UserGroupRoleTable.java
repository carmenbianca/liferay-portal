/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;UserGroupRole&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRole
 * @generated
 */
public class UserGroupRoleTable extends BaseTable<UserGroupRoleTable> {

	public static final UserGroupRoleTable INSTANCE = new UserGroupRoleTable();

	public final Column<UserGroupRoleTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<UserGroupRoleTable, Long> userGroupRoleId =
		createColumn(
			"userGroupRoleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserGroupRoleTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserGroupRoleTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserGroupRoleTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserGroupRoleTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private UserGroupRoleTable() {
		super("UserGroupRole", UserGroupRoleTable::new);
	}

}