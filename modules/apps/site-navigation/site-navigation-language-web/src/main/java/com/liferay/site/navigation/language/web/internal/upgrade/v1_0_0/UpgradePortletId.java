/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.language.web.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;
import com.liferay.site.navigation.language.constants.SiteNavigationLanguagePortletKeys;

/**
 * @author Eudaldo Alonso
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"82", SiteNavigationLanguagePortletKeys.SITE_NAVIGATION_LANGUAGE}
		};
	}

}