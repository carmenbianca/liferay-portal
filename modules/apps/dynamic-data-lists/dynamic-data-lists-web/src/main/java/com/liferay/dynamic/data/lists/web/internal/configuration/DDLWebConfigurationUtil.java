/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.web.internal.configuration;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.configuration.Filter;

/**
 * @author Rafael Praxedes
 */
public class DDLWebConfigurationUtil {

	public static String get(String key, Filter filter) {
		return _configuration.get(key, filter);
	}

	private static final Configuration _configuration =
		ConfigurationFactoryUtil.getConfiguration(
			DDLWebConfigurationUtil.class.getClassLoader(), "portlet");

}