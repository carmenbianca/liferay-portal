/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.upgrade.v7_0_0.UpgradeUserNotificationEvent;
import com.liferay.portal.upgrade.v7_0_1.UpgradeDocumentLibrary;
import com.liferay.portal.upgrade.v7_0_1.UpgradeLayoutBranch;
import com.liferay.portal.upgrade.v7_0_1.UpgradeMessageBoards;
import com.liferay.portal.upgrade.v7_0_1.UpgradeModules;
import com.liferay.portal.upgrade.v7_0_1.UpgradeSchema;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeProcess_7_0_1 extends UpgradeProcess {

	@Override
	public int getThreshold() {
		return ReleaseInfo.RELEASE_7_0_1_BUILD_NUMBER;
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgrade(new UpgradeSchema());

		upgrade(new UpgradeDocumentLibrary());
		upgrade(new UpgradeLayoutBranch());
		upgrade(new UpgradeMessageBoards());
		upgrade(new UpgradeModules());
		upgrade(new UpgradeUserNotificationEvent());

		clearIndexesCache();
	}

}