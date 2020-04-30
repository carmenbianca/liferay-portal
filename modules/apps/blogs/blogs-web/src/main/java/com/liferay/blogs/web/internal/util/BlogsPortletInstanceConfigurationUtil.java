/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.util;

import com.liferay.blogs.web.internal.configuration.BlogsPortletInstanceConfiguration;
import com.liferay.blogs.web.internal.constants.BlogsWebConstants;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.settings.PortletInstanceSettingsLocator;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alejandro Tardín
 */
public class BlogsPortletInstanceConfigurationUtil {

	public static BlogsPortletInstanceConfiguration
			getBlogsPortletInstanceConfiguration(ThemeDisplay themeDisplay)
		throws ConfigurationException {

		HttpServletRequest httpServletRequest = themeDisplay.getRequest();

		BlogsPortletInstanceConfiguration blogsPortletInstanceConfiguration =
			(BlogsPortletInstanceConfiguration)httpServletRequest.getAttribute(
				BlogsWebConstants.BLOGS_PORTLET_INSTANCE_CONFIGURATION);

		if (blogsPortletInstanceConfiguration == null) {
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			blogsPortletInstanceConfiguration =
				ConfigurationProviderUtil.getConfiguration(
					BlogsPortletInstanceConfiguration.class,
					new PortletInstanceSettingsLocator(
						themeDisplay.getLayout(), portletDisplay.getId()));

			httpServletRequest.setAttribute(
				BlogsWebConstants.BLOGS_PORTLET_INSTANCE_CONFIGURATION,
				blogsPortletInstanceConfiguration);
		}

		return blogsPortletInstanceConfiguration;
	}

}