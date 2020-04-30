/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.wedeploy.internal.util;

import com.liferay.gradle.util.Validator;

import java.lang.reflect.Method;

import org.gradle.api.GradleException;

/**
 * @author Andrea Di Giorgi
 */
public class GradleUtil extends com.liferay.gradle.util.GradleUtil {

	public static Object getProperty(Object object, String name) {
		try {
			Class<?> clazz = object.getClass();

			Method hasPropertyMethod = clazz.getMethod(
				"hasProperty", String.class);

			boolean hasProperty = (boolean)hasPropertyMethod.invoke(
				object, name);

			if (!hasProperty) {
				return null;
			}

			Method getPropertyMethod = clazz.getMethod(
				"getProperty", String.class);

			Object value = getPropertyMethod.invoke(object, name);

			if ((value instanceof String) && Validator.isNull((String)value)) {
				value = null;
			}

			return value;
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new GradleException(
				"Unable to get property", reflectiveOperationException);
		}
	}

	public static String getProperty(
		Object object, String name, String defaultValue) {

		Object value = getProperty(object, name);

		if (value == null) {
			return defaultValue;
		}

		return toString(value);
	}

}