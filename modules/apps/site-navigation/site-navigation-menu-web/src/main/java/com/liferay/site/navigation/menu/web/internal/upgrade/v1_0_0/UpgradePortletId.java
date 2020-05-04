/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.menu.web.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;
import com.liferay.site.navigation.menu.web.internal.constants.SiteNavigationMenuPortletKeys;

/**
 * @author Marcellus Tavares
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"71", SiteNavigationMenuPortletKeys.SITE_NAVIGATION_MENU}
		};
	}

}