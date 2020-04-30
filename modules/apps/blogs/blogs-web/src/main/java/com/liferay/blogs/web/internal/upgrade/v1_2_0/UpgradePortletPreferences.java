/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.upgrade.v1_2_0;

import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletPreferences;

import javax.portlet.PortletPreferences;

/**
 * @author Alejandro Tardín
 */
public class UpgradePortletPreferences extends BaseUpgradePortletPreferences {

	@Override
	protected String[] getPortletIds() {
		return new String[] {"com_liferay_blogs_web_portlet_BlogsPortlet"};
	}

	@Override
	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		String socialBookmarksDisplayStyle = portletPreferences.getValue(
			"socialBookmarksDisplayStyle", "menu");

		if (!socialBookmarksDisplayStyle.equals("menu")) {
			portletPreferences.setValue(
				"socialBookmarksDisplayStyle", "inline");
		}

		return PortletPreferencesFactoryUtil.toXML(portletPreferences);
	}

}