/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

import java.util.List;

/**
 * @author Raymond Augé
 * @author Jorge Ferrer
 */
public interface SettingsFactory {

	public ArchivedSettings getPortletInstanceArchivedSettings(
			long groupId, String portletId, String name)
		throws SettingsException;

	public List<ArchivedSettings> getPortletInstanceArchivedSettingsList(
		long groupId, String portletId);

	public Settings getSettings(SettingsLocator settingsLocator)
		throws SettingsException;

	public SettingsDescriptor getSettingsDescriptor(String settingsId);

	public void registerSettingsMetadata(
		Class<?> settingsClass, Object configurationBean,
		FallbackKeys fallbackKeys);

}