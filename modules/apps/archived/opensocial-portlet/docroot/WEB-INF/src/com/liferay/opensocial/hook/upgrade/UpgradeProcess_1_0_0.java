/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.hook.upgrade;

import com.liferay.opensocial.hook.upgrade.v1_0_0.UpgradeGadget;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Dennis Ju
 */
public class UpgradeProcess_1_0_0 extends UpgradeProcess {

	@Override
	public int getThreshold() {
		return 100;
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgrade(new UpgradeGadget());
	}

}