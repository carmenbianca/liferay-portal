/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resource.manager;

import com.liferay.portal.kernel.resource.ClassLoaderResourceRetriever;
import com.liferay.portal.kernel.resource.ResourceRetriever;

/**
 * @author Miguel Pastor
 */
public class ClassLoaderResourceManager implements ResourceManager {

	public ClassLoaderResourceManager(ClassLoader classLoader) {
		if (classLoader != null) {
			_classLoader = classLoader;
		}
		else {
			_classLoader = ClassLoaderResourceManager.class.getClassLoader();
		}
	}

	public ClassLoader getClassLoader() {
		return _classLoader;
	}

	@Override
	public ResourceRetriever getResourceRetriever(String location) {
		return new ClassLoaderResourceRetriever(_classLoader, location);
	}

	private final ClassLoader _classLoader;

}