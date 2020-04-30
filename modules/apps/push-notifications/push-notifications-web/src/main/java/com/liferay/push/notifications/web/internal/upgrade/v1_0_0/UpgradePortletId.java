/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.web.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;
import com.liferay.push.notifications.constants.PushNotificationsPortletKeys;

/**
 * @author Andrea Di Giorgi
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{
				"1_WAR_pushnotificationsportlet",
				PushNotificationsPortletKeys.PUSH_NOTIFICATIONS
			}
		};
	}

}