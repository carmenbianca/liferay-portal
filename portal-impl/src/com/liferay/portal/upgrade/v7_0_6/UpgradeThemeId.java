/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_6;

import com.liferay.portal.kernel.upgrade.BaseUpgradeThemeId;

/**
 * @author Michael Bowerman
 */
public class UpgradeThemeId extends BaseUpgradeThemeId {

	public String[][] getThemeIds() {
		return new String[][] {
			{"classic", "classic_WAR_classictheme"},
			{"controlpanel", "admin_WAR_admintheme"}
		};
	}

}