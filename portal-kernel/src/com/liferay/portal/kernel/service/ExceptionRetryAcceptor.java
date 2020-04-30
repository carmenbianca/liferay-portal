/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import java.util.Map;

/**
 * @author Matthew Tambara
 */
public class ExceptionRetryAcceptor implements RetryAcceptor {

	public static final String EXCEPTION_NAME = "EXCEPTION_NAME";

	@Override
	public boolean acceptException(
		Throwable t, Map<String, String> propertyMap) {

		String name = propertyMap.get(EXCEPTION_NAME);

		if (name == null) {
			throw new IllegalArgumentException(
				"Missing property " + EXCEPTION_NAME);
		}

		while (true) {
			Class<?> clazz = t.getClass();

			ClassLoader classLoader = clazz.getClassLoader();

			if (classLoader == null) {
				classLoader = ClassLoader.getSystemClassLoader();
			}

			try {
				Class<?> exceptionClass = classLoader.loadClass(name);

				if (exceptionClass.isInstance(t)) {
					return true;
				}
			}
			catch (ClassNotFoundException classNotFoundException) {
			}

			Throwable cause = t.getCause();

			if ((t == cause) || (cause == null)) {
				break;
			}

			t = cause;
		}

		return false;
	}

	@Override
	public boolean acceptResult(
		Object returnValue, Map<String, String> propertyMap) {

		return false;
	}

}