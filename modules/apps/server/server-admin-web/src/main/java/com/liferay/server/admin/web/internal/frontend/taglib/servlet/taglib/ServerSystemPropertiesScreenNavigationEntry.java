/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.server.admin.web.internal.frontend.taglib.servlet.taglib;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationCategory;
import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.server.admin.web.internal.constants.ServerAdminNavigationEntryConstants;

import java.io.IOException;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Albert Lee
 */
@Component(
	property = {
		"screen.navigation.category.order:Integer=10",
		"screen.navigation.entry.order:Integer=10"
	},
	service = {ScreenNavigationCategory.class, ScreenNavigationEntry.class}
)
public class ServerSystemPropertiesScreenNavigationEntry
	implements ScreenNavigationCategory, ScreenNavigationEntry {

	public String getCategoryKey() {
		return ServerAdminNavigationEntryConstants.
			CATEGORY_KEY_SYSTEM_PROPERTIES;
	}

	public String getEntryKey() {
		return ServerAdminNavigationEntryConstants.ENTRY_KEY_SYSTEM_PROPERTIES;
	}

	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "system-properties");
	}

	public String getScreenNavigationKey() {
		return ServerAdminNavigationEntryConstants.
			SCREEN_NAVIGATION_KEY_PROPERTIES;
	}

	public void render(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		_jspRenderer.renderJSP(
			httpServletRequest, httpServletResponse, "/system_properties.jsp");
	}

	@Reference
	private JSPRenderer _jspRenderer;

}