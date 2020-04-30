/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_0.util.OrganizationTable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Brian Wing Shun Chan
 * @author Christopher Kian
 */
public class UpgradeOrganization extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(OrganizationTable.class, new AlterColumnType("statusId", "LONG"));

		upgradeOrganizationLogoId();
	}

	protected void upgradeOrganizationLogoId() throws SQLException {
		try (PreparedStatement ps1 = connection.prepareStatement(
				"select groupId, logoId from LayoutSet where logoId > 0 and " +
					"privateLayout = ?");
			PreparedStatement ps2 = connection.prepareStatement(
				"select classPK from Group_ where groupId = ?");
			PreparedStatement ps3 = connection.prepareStatement(
				"update Organization_ set logoId = ? where organizationId = " +
					"?")) {

			ps1.setBoolean(1, false);

			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next()) {
				long groupId = rs1.getLong("groupId");
				long logoId = rs1.getLong("logoId");

				ps2.setLong(1, groupId);

				ResultSet rs2 = ps2.executeQuery();

				while (rs2.next()) {
					long classPK = rs2.getLong("classPK");

					ps3.setLong(1, logoId);
					ps3.setLong(2, classPK);

					ps3.executeUpdate();
				}
			}
		}
	}

}