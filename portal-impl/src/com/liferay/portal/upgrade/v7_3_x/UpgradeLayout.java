/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_3_x;

import com.liferay.portal.dao.orm.common.SQLTransformer;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_3_x.util.LayoutTable;

import java.sql.PreparedStatement;

/**
 * @author Preston Crary
 */
public class UpgradeLayout extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasColumn("Layout", "headId") || hasColumn("Layout", "head")) {
			alter(
				LayoutTable.class, new AlterTableDropColumn("headId"),
				new AlterTableDropColumn("head"));
		}

		if (!hasColumn("Layout", "masterLayoutPlid")) {
			alter(
				LayoutTable.class,
				new AlterTableAddColumn("masterLayoutPlid", "LONG"));
		}

		if (!hasColumn("Layout", "status")) {
			alter(
				LayoutTable.class,
				new AlterTableAddColumn("status", "INTEGER"));
		}

		if (!hasColumn("Layout", "statusByUserId")) {
			alter(
				LayoutTable.class,
				new AlterTableAddColumn("statusByUserId", "LONG"));
		}

		if (!hasColumn("Layout", "statusByUserName")) {
			alter(
				LayoutTable.class,
				new AlterTableAddColumn(
					"statusByUserName", "VARCHAR(75) null"));
		}

		if (!hasColumn("Layout", "statusDate")) {
			alter(
				LayoutTable.class,
				new AlterTableAddColumn("statusDate", "DATE null"));
		}

		try (PreparedStatement ps = connection.prepareStatement(
				SQLTransformer.transform(
					"update Layout set masterLayoutPlid = 0, status = 0"))) {

			if (ps.executeUpdate() == 0) {
				return;
			}
		}

		runSQL("DROP_TABLE_IF_EXISTS(LayoutVersion)");
	}

}