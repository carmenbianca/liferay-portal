/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.internal.upgrade.v2_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Ryan Park
 */
public class UpgradeApp extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("Marketplace_App", "required")) {
			runSQL("alter table Marketplace_App add required BOOLEAN");

			runSQL("update Marketplace_App set required = FALSE");
		}
	}

}