/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalClassLoaderUtil {

	public static ClassLoader getClassLoader() {
		return _classLoader;
	}

	public static boolean isPortalClassLoader(ClassLoader classLoader) {
		if (classLoader == _classLoader) {
			return true;
		}

		return false;
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	private static ClassLoader _classLoader;

}