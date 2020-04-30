/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.internal.upgrade.v2_0_2;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Adam Brandizzi
 * @author Ryan Park
 */
public class UpgradeApp extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL("delete from Marketplace_App where appId is not null");
		runSQL("delete from Marketplace_Module where moduleId is not null");
	}

}