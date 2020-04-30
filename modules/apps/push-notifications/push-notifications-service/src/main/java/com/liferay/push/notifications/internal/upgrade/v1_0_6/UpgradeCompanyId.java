/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.internal.upgrade.v1_0_6;

import com.liferay.portal.kernel.upgrade.BaseUpgradeCompanyId;

/**
 * @author Bruno Farache
 */
public class UpgradeCompanyId extends BaseUpgradeCompanyId {

	@Override
	protected TableUpdater[] getTableUpdaters() {
		return new TableUpdater[] {
			new TableUpdater("PushNotificationsDevice", "User_", "userId")
		};
	}

}