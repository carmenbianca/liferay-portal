/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.web.internal.upgrade.v1_0_0;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletPreferences;

import javax.portlet.PortletPreferences;

/**
 * @author Inácio Nery
 */
public class UpgradePortletPreferences extends BaseUpgradePortletPreferences {

	@Override
	protected String getUpdatePortletPreferencesWhereClause() {
		StringBundler sb = new StringBundler(5);

		sb.append("(preferences like '%isoTimeFormat%");
		sb.append(Boolean.TRUE.toString());
		sb.append("%') or (preferences like '%isoTimeFormat%");
		sb.append(Boolean.FALSE.toString());
		sb.append("%')");

		return sb.toString();
	}

	@Override
	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		String isoTimeFormat = portletPreferences.getValue(
			"isoTimeFormat", Boolean.FALSE.toString());

		if (isoTimeFormat.equals(Boolean.TRUE.toString())) {
			portletPreferences.setValue("timeFormat", "24-hour");
		}
		else {
			portletPreferences.setValue("timeFormat", "am-pm");
		}

		portletPreferences.reset("isoTimeFormat");

		return PortletPreferencesFactoryUtil.toXML(portletPreferences);
	}

}