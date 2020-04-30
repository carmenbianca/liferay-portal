/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.directory.web.internal.display.context;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.site.navigation.directory.web.internal.configuration.SitesDirectoryPortletInstanceConfiguration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Juergen Kappler
 */
public class SitesDirectoryDisplayContext {

	public SitesDirectoryDisplayContext(HttpServletRequest httpServletRequest)
		throws ConfigurationException {

		_httpServletRequest = httpServletRequest;

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		_sitesDirectoryPortletInstanceConfiguration =
			portletDisplay.getPortletInstanceConfiguration(
				SitesDirectoryPortletInstanceConfiguration.class);
	}

	public String getDisplayStyle() {
		if (_displayStyle != null) {
			return _displayStyle;
		}

		_displayStyle = ParamUtil.getString(
			_httpServletRequest, "displayStyle",
			_sitesDirectoryPortletInstanceConfiguration.displayStyle());

		return _displayStyle;
	}

	public String getSites() {
		if (_sites != null) {
			return _sites;
		}

		_sites = ParamUtil.getString(
			_httpServletRequest, "sites",
			_sitesDirectoryPortletInstanceConfiguration.sites());

		return _sites;
	}

	private String _displayStyle;
	private final HttpServletRequest _httpServletRequest;
	private String _sites;
	private final SitesDirectoryPortletInstanceConfiguration
		_sitesDirectoryPortletInstanceConfiguration;

}