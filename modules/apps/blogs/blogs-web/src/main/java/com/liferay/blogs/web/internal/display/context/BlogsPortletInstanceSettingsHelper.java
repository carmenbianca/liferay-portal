/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.display.context;

import com.liferay.blogs.web.internal.configuration.BlogsPortletInstanceConfiguration;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sergio González
 */
public class BlogsPortletInstanceSettingsHelper {

	public BlogsPortletInstanceSettingsHelper(
		HttpServletRequest httpServletRequest,
		BlogsPortletInstanceConfiguration blogsPortletInstanceConfiguration) {

		_httpServletRequest = httpServletRequest;
		_blogsPortletInstanceConfiguration = blogsPortletInstanceConfiguration;
	}

	public long getDisplayStyleGroupId() {
		if (_displayStyleGroupId != 0) {
			return _displayStyleGroupId;
		}

		_displayStyleGroupId =
			_blogsPortletInstanceConfiguration.displayStyleGroupId();

		if (_displayStyleGroupId <= 0) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)_httpServletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			_displayStyleGroupId = themeDisplay.getScopeGroupId();
		}

		return _displayStyleGroupId;
	}

	private final BlogsPortletInstanceConfiguration
		_blogsPortletInstanceConfiguration;
	private long _displayStyleGroupId;
	private final HttpServletRequest _httpServletRequest;

}