/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.settings.web.internal.portal.settings.configuration.admin.display;

import com.liferay.analytics.settings.configuration.AnalyticsConfiguration;
import com.liferay.analytics.settings.web.internal.constants.AnalyticsSettingsWebKeys;
import com.liferay.analytics.settings.web.internal.user.AnalyticsUsersManager;
import com.liferay.configuration.admin.display.ConfigurationScreen;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Marcellus Tavares
 */
public abstract class BaseAnalyticsConfigurationScreen
	implements ConfigurationScreen {

	@Override
	public String getCategoryKey() {
		return "analytics-cloud";
	}

	@Override
	public String getName(Locale locale) {
		return LanguageUtil.get(
			ResourceBundleUtil.getBundle(locale, getClass()), getKey());
	}

	@Override
	public String getScope() {
		return "company";
	}

	@Override
	public void render(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		try {
			ServletContext servletContext = getServletContext();

			RequestDispatcher requestDispatcher =
				servletContext.getRequestDispatcher(getJspPath());

			setHttpServletRequestAttributes(httpServletRequest);

			requestDispatcher.include(httpServletRequest, httpServletResponse);
		}
		catch (Exception exception) {
			throw new IOException(
				"Unable to render " + getJspPath(), exception);
		}
	}

	protected abstract String getJspPath();

	protected abstract ServletContext getServletContext();

	protected void setHttpServletRequestAttributes(
			HttpServletRequest httpServletRequest)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		httpServletRequest.setAttribute(
			AnalyticsSettingsWebKeys.ANALYTICS_CONFIGURATION,
			configurationProvider.getCompanyConfiguration(
				AnalyticsConfiguration.class, themeDisplay.getCompanyId()));

		httpServletRequest.setAttribute(
			AnalyticsSettingsWebKeys.ANALYTICS_USERS_MANAGER,
			analyticsUsersManager);
	}

	@Reference
	protected AnalyticsUsersManager analyticsUsersManager;

	@Reference
	protected ConfigurationProvider configurationProvider;

}