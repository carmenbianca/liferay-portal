/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.lang.reflect.Field;

/**
 * @author     Shuyang Zhou
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class ReferenceRegistry {

	public static void registerReference(
		Class<?> clazz, Object object, String fieldName) {
	}

	public static void registerReference(Class<?> clazz, String fieldName) {
	}

	public static void registerReference(Field field) {
	}

	public static void registerReference(Object object, Field field) {
	}

	public static void releaseReferences() {
	}

}