/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.configuration.Filter;

import java.util.Properties;

/**
 * @author Brian Wing Shun Chan
 */
public class PropsUtil {

	public static boolean contains(String key) {
		return getProps().contains(key);
	}

	public static String get(String key) {
		return getProps().get(key);
	}

	public static String get(String key, Filter filter) {
		return getProps().get(key, filter);
	}

	public static String[] getArray(String key) {
		return getProps().getArray(key);
	}

	public static String[] getArray(String key, Filter filter) {
		return getProps().getArray(key, filter);
	}

	public static Properties getProperties() {
		return getProps().getProperties();
	}

	public static Properties getProperties(
		String prefix, boolean removePrefix) {

		return getProps().getProperties(prefix, removePrefix);
	}

	public static Props getProps() {
		return _props;
	}

	public static void setProps(Props props) {
		_props = props;
	}

	private static Props _props;

}