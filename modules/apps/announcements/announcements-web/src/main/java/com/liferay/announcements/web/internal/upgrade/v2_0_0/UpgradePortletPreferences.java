/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.web.internal.upgrade.v2_0_0;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.portal.kernel.util.PortletKeys;

/**
 * @author Roberto Díaz
 */
public class UpgradePortletPreferences extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			runSQL(
				StringBundler.concat(
					"delete from PortletPreferences where portletId = '",
					_PORTLET_ID, "' AND ownerType = ",
					PortletKeys.PREFS_OWNER_TYPE_COMPANY));
		}
	}

	private static final String _PORTLET_ID =
		"com_liferay_announcements_web_portlet_AnnouncementsPortlet";

}