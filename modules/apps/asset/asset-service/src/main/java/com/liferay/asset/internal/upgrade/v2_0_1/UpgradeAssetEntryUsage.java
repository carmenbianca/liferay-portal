/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.internal.upgrade.v2_0_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Alberto Chaparro
 */
public class UpgradeAssetEntryUsage extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL("drop index IX_71A0231C on AssetEntryUsage");
	}

}