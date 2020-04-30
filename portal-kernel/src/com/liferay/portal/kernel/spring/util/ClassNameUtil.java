/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.spring.util;

/**
 * @author Shuyang Zhou
 */
public class ClassNameUtil {

	public static String getClassName(String className)
		throws ClassNotFoundException {

		Thread currentThread = Thread.currentThread();

		ClassLoader classLoader = currentThread.getContextClassLoader();

		return getClassName(className, classLoader);
	}

	public static String getClassName(String className, ClassLoader classLoader)
		throws ClassNotFoundException {

		Class<?> clazz = Class.forName(className, false, classLoader);

		return clazz.getName();
	}

	public static String getSimpleClassName(String className)
		throws ClassNotFoundException {

		Thread currentThread = Thread.currentThread();

		ClassLoader classLoader = currentThread.getContextClassLoader();

		return getSimpleClassName(className, classLoader);
	}

	public static String getSimpleClassName(
			String className, ClassLoader classLoader)
		throws ClassNotFoundException {

		Class<?> clazz = Class.forName(className, false, classLoader);

		return clazz.getSimpleName();
	}

}