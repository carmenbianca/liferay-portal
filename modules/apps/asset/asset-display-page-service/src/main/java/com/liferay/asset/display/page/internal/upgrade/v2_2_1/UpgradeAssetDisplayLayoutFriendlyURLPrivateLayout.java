/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.display.page.internal.upgrade.v2_2_1;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.jdbc.AutoBatchPreparedStatementUtil;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Pavel Savinov
 */
public class UpgradeAssetDisplayLayoutFriendlyURLPrivateLayout
	extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeAssetDisplayLayoutFriendlyURLs();
	}

	private void _upgradeAssetDisplayLayoutFriendlyURLs() throws Exception {
		StringBundler sb = new StringBundler(4);

		sb.append("select distinct LayoutFriendlyURL.plid from ");
		sb.append("LayoutFriendlyURL inner join Layout on Layout.plid = ");
		sb.append("LayoutFriendlyURL.plid where Layout.type_ = ? and ");
		sb.append("LayoutFriendlyURL.privateLayout = ?");

		try (PreparedStatement ps1 = connection.prepareStatement(sb.toString());
			PreparedStatement ps2 = AutoBatchPreparedStatementUtil.autoBatch(
				connection.prepareStatement(
					"update LayoutFriendlyURL set privateLayout = ? where " +
						"plid = ?"))) {

			ps1.setString(1, LayoutConstants.TYPE_ASSET_DISPLAY);
			ps1.setBoolean(2, true);

			try (ResultSet rs = ps1.executeQuery()) {
				while (rs.next()) {
					long plid = rs.getLong("plid");

					ps2.setBoolean(1, false);
					ps2.setLong(2, plid);

					ps2.addBatch();
				}

				ps2.executeBatch();
			}
		}
	}

}