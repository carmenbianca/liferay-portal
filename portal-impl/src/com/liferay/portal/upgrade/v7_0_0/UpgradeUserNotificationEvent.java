/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_0.util.UserNotificationEventTable;

/**
 * @author Adolfo Pérez
 */
public class UpgradeUserNotificationEvent extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {

		// Check the column type because this class is also used in
		// UpgradeProcess_7_0_1

		if (hasColumnType(
				"UserNotificationEvent", "type_", "VARCHAR(200) null")) {

			return;
		}

		alter(
			UserNotificationEventTable.class,
			new AlterColumnType("type_", "VARCHAR(200) null"));
	}

}