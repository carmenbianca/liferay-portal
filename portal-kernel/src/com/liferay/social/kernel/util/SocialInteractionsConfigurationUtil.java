/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.util;

import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.social.kernel.util.SocialInteractionsConfiguration.SocialInteractionsType;

import javax.portlet.PortletPreferences;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Adolfo Pérez
 * @author Sergio González
 */
public class SocialInteractionsConfigurationUtil {

	public static SocialInteractionsConfiguration
		getSocialInteractionsConfiguration(
			long companyId, HttpServletRequest httpServletRequest,
			String serviceName) {

		PortletPreferences portletPreferences = PrefsPropsUtil.getPreferences(
			companyId, true);

		boolean socialInteractionsFriendsEnabled = PrefsParamUtil.getBoolean(
			portletPreferences, httpServletRequest,
			"socialInteractionsFriendsEnabled" + serviceName, true);
		boolean socialInteractionsSitesEnabled = PrefsParamUtil.getBoolean(
			portletPreferences, httpServletRequest,
			"socialInteractionsSitesEnabled" + serviceName, true);
		SocialInteractionsType socialInteractionsType =
			SocialInteractionsType.parse(
				PrefsParamUtil.getString(
					portletPreferences, httpServletRequest,
					"socialInteractionsType" + serviceName,
					SocialInteractionsType.ALL_USERS.toString()));

		return new SocialInteractionsConfiguration(
			socialInteractionsFriendsEnabled, socialInteractionsSitesEnabled,
			socialInteractionsType);
	}

	public static SocialInteractionsConfiguration
		getSocialInteractionsConfiguration(long companyId, String serviceName) {

		boolean socialInteractionsFriendsEnabled = PrefsPropsUtil.getBoolean(
			companyId, "socialInteractionsFriendsEnabled" + serviceName, true);
		boolean socialInteractionsSitesEnabled = PrefsPropsUtil.getBoolean(
			companyId, "socialInteractionsSitesEnabled" + serviceName, true);
		SocialInteractionsType socialInteractionsType =
			SocialInteractionsType.parse(
				PrefsPropsUtil.getString(
					companyId, "socialInteractionsType" + serviceName,
					SocialInteractionsType.ALL_USERS.toString()));

		return new SocialInteractionsConfiguration(
			socialInteractionsFriendsEnabled, socialInteractionsSitesEnabled,
			socialInteractionsType);
	}

}