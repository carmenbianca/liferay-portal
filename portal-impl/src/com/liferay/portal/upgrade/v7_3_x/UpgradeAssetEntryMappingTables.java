/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_3_x;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Samuel Trong Tran
 */
public class UpgradeAssetEntryMappingTables extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeAssetEntryTableMapping("AssetEntries_AssetCategories");
		_upgradeAssetEntryTableMapping("AssetEntries_AssetTags");
	}

	private void _upgradeAssetEntryTableMapping(String tableName)
		throws Exception {

		if (hasColumn(tableName, "changeType")) {
			runSQL("alter table " + tableName + " drop column changeType");
		}

		if (!hasColumn(tableName, "ctChangeType")) {
			runSQL("alter table " + tableName + " add ctChangeType BOOLEAN");
		}
	}

}