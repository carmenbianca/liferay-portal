/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.util;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class FilterClassLoader extends ClassLoader {

	public FilterClassLoader(ClassLoader classLoader) {
		super(classLoader);
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if (name.startsWith("net.sf.ehcache.") ||
			name.startsWith("org.hibernate.") ||
			name.startsWith("org.springframework.")) {

			ClassLoader portalClassLoader =
				PortalClassLoaderUtil.getClassLoader();

			return portalClassLoader.loadClass(name);
		}

		return super.loadClass(name);
	}

}