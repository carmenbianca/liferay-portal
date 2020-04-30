/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.frontend.taglib.servlet.taglib;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationCategory;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.users.admin.constants.UserScreenNavigationEntryConstants;

import java.util.Locale;

/**
 * @author Drew Brokke
 */
public class OrganizationScreenNavigationCategory
	implements ScreenNavigationCategory {

	public OrganizationScreenNavigationCategory(String categoryKey) {
		_categoryKey = categoryKey;
	}

	@Override
	public String getCategoryKey() {
		return _categoryKey;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(
			ResourceBundleUtil.getBundle(
				locale, OrganizationScreenNavigationEntry.class),
			_categoryKey);
	}

	@Override
	public String getScreenNavigationKey() {
		return UserScreenNavigationEntryConstants.
			SCREEN_NAVIGATION_KEY_ORGANIZATIONS;
	}

	private final String _categoryKey;

}