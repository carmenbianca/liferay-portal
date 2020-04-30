/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.navigation.web.internal.upgrade.v1_0_1;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;
import com.liferay.wiki.navigation.web.internal.constants.WikiNavigationPortletKeys;

/**
 * @author Sergio González
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{
				"1_WAR_wikinavigationportlet",
				WikiNavigationPortletKeys.TREE_MENU
			},
			{"2_WAR_wikinavigationportlet", WikiNavigationPortletKeys.PAGE_MENU}
		};
	}

}