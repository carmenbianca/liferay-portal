/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.model.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.site.navigation.constants.SiteNavigationConstants;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteNavigationMenuImpl extends SiteNavigationMenuBaseImpl {

	@Override
	public String getTypeKey() {
		String navigationTypeKey = StringPool.BLANK;

		if (getType() == SiteNavigationConstants.TYPE_PRIMARY) {
			navigationTypeKey = "primary-navigation";
		}
		else if (getType() == SiteNavigationConstants.TYPE_SECONDARY) {
			navigationTypeKey = "secondary-navigation";
		}
		else if (getType() == SiteNavigationConstants.TYPE_SOCIAL) {
			navigationTypeKey = "social-navigation";
		}

		return navigationTypeKey;
	}

	@Override
	public boolean isPrimary() {
		if (getType() == SiteNavigationConstants.TYPE_PRIMARY) {
			return true;
		}

		return false;
	}

}