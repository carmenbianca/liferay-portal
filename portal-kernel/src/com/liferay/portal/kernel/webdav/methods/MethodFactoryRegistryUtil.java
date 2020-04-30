/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webdav.methods;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MethodFactoryRegistryUtil {

	public static MethodFactory getDefaultMethodFactory() {
		return getMethodFactoryRegistry().getDefaultMethodFactory();
	}

	public static MethodFactory getMethodFactory(String className) {
		return getMethodFactoryRegistry().getMethodFactory(className);
	}

	public static List<MethodFactory> getMethodFactoryFactories() {
		return getMethodFactoryRegistry().getMethodFactories();
	}

	public static MethodFactoryRegistry getMethodFactoryRegistry() {
		return _methodFactoryRegistry;
	}

	public static void registerMethodFactory(MethodFactory methodFactory) {
		getMethodFactoryRegistry().registerMethodFactory(methodFactory);
	}

	public static void unregisterMethodFactory(MethodFactory methodFactory) {
		getMethodFactoryRegistry().unregisterMethodFactory(methodFactory);
	}

	public void setMethodFactoryRegistry(
		MethodFactoryRegistry methodFactoryRegistry) {

		_methodFactoryRegistry = methodFactoryRegistry;
	}

	private static MethodFactoryRegistry _methodFactoryRegistry;

}