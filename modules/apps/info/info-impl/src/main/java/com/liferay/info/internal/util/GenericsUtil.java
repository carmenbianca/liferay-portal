/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.internal.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Jorge Ferrer
 * @see com.liferay.analytics.reports.internal.util.GenericsUtil
 * @see com.liferay.layout.internal.list.retriever.util.GenericsUtil
 */
public class GenericsUtil {

	public static Class<?> getItemClass(Class clazz) {
		Type[] genericInterfaceTypes = clazz.getGenericInterfaces();

		for (Type genericInterfaceType : genericInterfaceTypes) {
			ParameterizedType parameterizedType =
				(ParameterizedType)genericInterfaceType;

			return (Class<?>)parameterizedType.getActualTypeArguments()[0];
		}

		Class<?> superClass = clazz.getSuperclass();

		if (superClass != null) {
			return getItemClass(superClass);
		}

		return Object.class;
	}

	public static Class<?> getItemClass(Object object) {
		Class<?> clazz = object.getClass();

		return getItemClass(clazz);
	}

	public static String getItemClassName(Object object) {
		Class<?> clazz = getItemClass(object);

		return clazz.getName();
	}

}