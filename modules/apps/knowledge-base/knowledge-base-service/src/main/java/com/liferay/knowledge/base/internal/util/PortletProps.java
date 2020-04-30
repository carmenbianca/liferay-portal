/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.util;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

/**
 * @author Adolfo Pérez
 */
public class PortletProps {

	public static String get(String key) {
		return _portletProps._configuration.get(key);
	}

	public static String[] getArray(String key) {
		return _portletProps._configuration.getArray(key);
	}

	private PortletProps() {
		Class<?> clazz = getClass();

		_configuration = ConfigurationFactoryUtil.getConfiguration(
			clazz.getClassLoader(), "portlet");
	}

	private static final PortletProps _portletProps = new PortletProps();

	private final Configuration _configuration;

}