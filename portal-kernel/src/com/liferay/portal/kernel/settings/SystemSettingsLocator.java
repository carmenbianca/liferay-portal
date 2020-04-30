/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

/**
 * @author Drew Brokke
 */
public class SystemSettingsLocator implements SettingsLocator {

	public SystemSettingsLocator(String configurationPid) {
		_configurationPid = configurationPid;
	}

	@Override
	public Settings getSettings() throws SettingsException {
		return _settingsLocatorHelper.getConfigurationBeanSettings(
			_configurationPid);
	}

	@Override
	public String getSettingsId() {
		return _configurationPid;
	}

	private final String _configurationPid;
	private final SettingsLocatorHelper _settingsLocatorHelper =
		SettingsLocatorHelperUtil.getSettingsLocatorHelper();

}