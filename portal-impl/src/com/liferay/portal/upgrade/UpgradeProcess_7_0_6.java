/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.upgrade.v7_0_6.UpgradeRepository;
import com.liferay.portal.upgrade.v7_0_6.UpgradeResourceActions;
import com.liferay.portal.upgrade.v7_0_6.UpgradeThemeId;

/**
 * @author Alberto Chaparro
 */
public class UpgradeProcess_7_0_6 extends UpgradeProcess {

	@Override
	public int getThreshold() {
		return ReleaseInfo.RELEASE_7_0_6_BUILD_NUMBER;
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgrade(new UpgradeRepository());
		upgrade(new UpgradeResourceActions());
		upgrade(new UpgradeThemeId());

		clearIndexesCache();
	}

	@Override
	protected boolean isSkipUpgradeProcess() throws Exception {
		if (hasColumnType("Repository", "name", "VARCHAR(200) null")) {
			return true;
		}

		return false;
	}

}