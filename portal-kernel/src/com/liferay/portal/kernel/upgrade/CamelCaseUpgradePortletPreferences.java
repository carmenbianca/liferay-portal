/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade;

import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.TextFormatter;

import java.util.Map;

import javax.portlet.PortletPreferences;

/**
 * @author Julio Camarero
 */
public class CamelCaseUpgradePortletPreferences
	extends BaseUpgradePortletPreferences {

	@Override
	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		Map<String, String[]> preferencesMap = portletPreferences.getMap();

		for (Map.Entry<String, String[]> entry : preferencesMap.entrySet()) {
			String oldName = entry.getKey();

			String newName = TextFormatter.format(oldName, TextFormatter.M);

			portletPreferences.reset(oldName);

			portletPreferences.setValues(newName, entry.getValue());
		}

		return PortletPreferencesFactoryUtil.toXML(portletPreferences);
	}

}