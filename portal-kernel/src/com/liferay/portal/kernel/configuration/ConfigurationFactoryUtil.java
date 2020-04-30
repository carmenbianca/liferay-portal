/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.configuration;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurationFactoryUtil {

	public static Configuration getConfiguration(
		ClassLoader classLoader, String name) {

		return getConfigurationFactory().getConfiguration(classLoader, name);
	}

	public static ConfigurationFactory getConfigurationFactory() {
		return _configurationFactory;
	}

	public static void setConfigurationFactory(
		ConfigurationFactory configurationFactory) {

		_configurationFactory = configurationFactory;
	}

	private static ConfigurationFactory _configurationFactory;

}