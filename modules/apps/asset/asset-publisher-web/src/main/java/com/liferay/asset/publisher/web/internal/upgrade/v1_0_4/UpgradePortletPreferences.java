/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.upgrade.v1_0_4;

import com.liferay.asset.publisher.constants.AssetPublisherPortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletPreferences;

import javax.portlet.PortletPreferences;

/**
 * @author Sergio González
 */
public class UpgradePortletPreferences extends BaseUpgradePortletPreferences {

	@Override
	protected String[] getPortletIds() {
		return new String[] {
			AssetPublisherPortletKeys.ASSET_PUBLISHER + "_INSTANCE_%"
		};
	}

	@Override
	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		String enableSocialBookmarks = portletPreferences.getValue(
			"enableSocialBookmarks", Boolean.TRUE.toString());

		if (!enableSocialBookmarks.equals(Boolean.TRUE.toString())) {
			portletPreferences.setValue(
				"socialBookmarksTypes", StringPool.BLANK);
		}

		portletPreferences.reset("enableSocialBookmarks");
		portletPreferences.reset("socialBookmarksDisplayPosition");

		return PortletPreferencesFactoryUtil.toXML(portletPreferences);
	}

}