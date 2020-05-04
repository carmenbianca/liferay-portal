/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.display.context.util;

import com.liferay.journal.configuration.JournalGroupServiceConfiguration;
import com.liferay.journal.constants.JournalConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ParameterMapSettingsLocator;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Juergen Kappler
 */
public class JournalWebRequestHelper {

	public JournalWebRequestHelper(HttpServletRequest httpServletRequest) {
		_httpServletRequest = httpServletRequest;
	}

	public JournalGroupServiceConfiguration
		getJournalGroupServiceConfiguration() {

		try {
			if (_journalGroupServiceConfiguration == null) {
				ThemeDisplay themeDisplay =
					(ThemeDisplay)_httpServletRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

				PortletDisplay portletDisplay =
					themeDisplay.getPortletDisplay();

				if (Validator.isNotNull(portletDisplay.getPortletResource())) {
					_journalGroupServiceConfiguration =
						ConfigurationProviderUtil.getConfiguration(
							JournalGroupServiceConfiguration.class,
							new ParameterMapSettingsLocator(
								_httpServletRequest.getParameterMap(),
								new GroupServiceSettingsLocator(
									themeDisplay.getSiteGroupId(),
									JournalConstants.SERVICE_NAME)));
				}
				else {
					_journalGroupServiceConfiguration =
						ConfigurationProviderUtil.getConfiguration(
							JournalGroupServiceConfiguration.class,
							new GroupServiceSettingsLocator(
								themeDisplay.getSiteGroupId(),
								JournalConstants.SERVICE_NAME));
				}
			}

			return _journalGroupServiceConfiguration;
		}
		catch (PortalException portalException) {
			throw new SystemException(portalException);
		}
	}

	private final HttpServletRequest _httpServletRequest;
	private JournalGroupServiceConfiguration _journalGroupServiceConfiguration;

}