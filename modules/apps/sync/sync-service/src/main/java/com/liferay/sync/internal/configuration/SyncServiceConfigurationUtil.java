/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.internal.configuration;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

/**
 * @author Shinn Lok
 */
public class SyncServiceConfigurationUtil {

	public static String get(String key) {
		return _configuration.get(key);
	}

	public static String[] getArray(String key) {
		return _configuration.getArray(key);
	}

	private static final Configuration _configuration =
		ConfigurationFactoryUtil.getConfiguration(
			SyncServiceConfigurationUtil.class.getClassLoader(), "portlet");

}