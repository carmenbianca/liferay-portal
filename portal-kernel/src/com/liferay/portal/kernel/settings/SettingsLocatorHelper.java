/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Iván Zaera
 */
@ProviderType
public interface SettingsLocatorHelper {

	public Settings getCompanyConfigurationBeanSettings(
		long companyId, String configurationPid, Settings parentSettings);

	public Settings getCompanyPortletPreferencesSettings(
		long companyId, String settingsId, Settings parentSettings);

	public Settings getConfigurationBeanSettings(String configurationPid);

	public Settings getGroupConfigurationBeanSettings(
		long groupId, String configurationPid, Settings parentSettings);

	public Settings getGroupPortletPreferencesSettings(
		long groupId, String settingsId, Settings parentSettings);

	public Settings getPortalPreferencesSettings(
		long companyId, Settings parentSettings);

	public Settings getPortletInstanceConfigurationBeanSettings(
		String portletId, String configurationPid, Settings parentSettings);

	public Settings getPortletInstancePortletPreferencesSettings(
		long companyId, long ownerId, int ownerType, long plid,
		String portletId, Settings parentSettings);

	public Settings getPortletInstancePortletPreferencesSettings(
		long companyId, long plid, String portletId, Settings parentSettings);

	public Settings getServerSettings(String settingsId);

}