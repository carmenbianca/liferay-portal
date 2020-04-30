/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.web.internal.upgrade.v1_1_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Adam Brandizzi
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[] getUninstanceablePortletIds() {
		return new String[] {
			"com_liferay_calendar_web_portlet_CalendarPortlet"
		};
	}

}