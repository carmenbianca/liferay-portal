/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_2_x;

import com.liferay.portal.kernel.upgrade.BaseUpgradeThemeId;

/**
 * @author Antonio Ortega
 */
public class UpgradeThemeId extends BaseUpgradeThemeId {

	protected String[][] getThemeIds() {
		return new String[][] {
			{
				"userdashboard_WAR_userdashboardtheme",
				"classic_WAR_classictheme"
			},
			{"userprofile_WAR_userprofiletheme", "classic_WAR_classictheme"}
		};
	}

}