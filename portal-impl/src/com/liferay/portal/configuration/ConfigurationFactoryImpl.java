/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactory;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.util.PropsFiles;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurationFactoryImpl implements ConfigurationFactory {

	public static final Configuration CONFIGURATION_PORTAL =
		new ConfigurationImpl(
			ConfigurationFactoryImpl.class.getClassLoader(), PropsFiles.PORTAL,
			CompanyConstants.SYSTEM, null);

	@Override
	public Configuration getConfiguration(
		ClassLoader classLoader, String name) {

		return new ConfigurationImpl(
			classLoader, name, CompanyConstants.SYSTEM, null);
	}

}