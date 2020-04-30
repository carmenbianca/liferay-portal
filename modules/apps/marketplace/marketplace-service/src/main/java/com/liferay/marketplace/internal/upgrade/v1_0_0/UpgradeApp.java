/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Ryan Park
 */
public class UpgradeApp extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		updateModules();
	}

	protected void updateModules() throws Exception {
		if (!hasColumn("Marketplace_App", "title")) {
			runSQL("alter table Marketplace_App add title VARCHAR(75)");
		}

		if (!hasColumn("Marketplace_App", "description")) {
			runSQL("alter table Marketplace_App add description STRING");
		}

		if (!hasColumn("Marketplace_App", "category")) {
			runSQL("alter table Marketplace_App add category VARCHAR(75)");
		}

		if (!hasColumn("Marketplace_App", "iconURL")) {
			runSQL("alter table Marketplace_App add iconURL STRING");
		}

		if (!hasColumn("Marketplace_App", "version")) {
			runSQL("alter table Marketplace_App add version VARCHAR(75)");
		}
	}

}