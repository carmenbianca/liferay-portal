/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;OrgGroupRole&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see OrgGroupRole
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrgGroupRoleTable extends BaseTable<OrgGroupRoleTable> {

	public static final OrgGroupRoleTable INSTANCE = new OrgGroupRoleTable();

	public final Column<OrgGroupRoleTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<OrgGroupRoleTable, Long> organizationId = createColumn(
		"organizationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OrgGroupRoleTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OrgGroupRoleTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OrgGroupRoleTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private OrgGroupRoleTable() {
		super("OrgGroupRole", OrgGroupRoleTable::new);
	}

}