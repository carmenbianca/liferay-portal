/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_3_x;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_3_x.util.AssetCategoryTable;

/**
 * @author Jürgen Kappler
 */
public class UpgradeAssetCategoryName extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasColumnType("AssetCategory", "name", "VARCHAR(75) null")) {
			alter(
				AssetCategoryTable.class,
				new AlterColumnType("name", "VARCHAR(255) null"));
		}
	}

}