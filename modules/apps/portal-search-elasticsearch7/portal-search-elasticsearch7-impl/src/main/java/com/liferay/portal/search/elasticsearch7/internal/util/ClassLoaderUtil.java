/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.util;

import java.util.function.Supplier;

/**
 * @author André de Oliveira
 */
public class ClassLoaderUtil {

	public static <T> T getWithContextClassLoader(
		Supplier<T> supplier, Class<?> clazz) {

		Thread thread = Thread.currentThread();

		ClassLoader contextClassLoader = thread.getContextClassLoader();

		thread.setContextClassLoader(clazz.getClassLoader());

		try {
			return supplier.get();
		}
		finally {
			thread.setContextClassLoader(contextClassLoader);
		}
	}

}