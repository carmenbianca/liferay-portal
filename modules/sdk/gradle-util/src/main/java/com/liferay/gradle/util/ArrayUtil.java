/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.util;

/**
 * @author Brian Wing Shun Chan
 */
public class ArrayUtil {

	public static boolean contains(Object[] array, Object value) {
		if (isEmpty(array)) {
			return false;
		}

		for (Object obj : array) {
			if (value == null) {
				if (obj == null) {
					return true;
				}
			}
			else if (value.equals(obj)) {
				return true;
			}
		}

		return false;
	}

	public static boolean isEmpty(Object[] array) {
		if ((array == null) || (array.length == 0)) {
			return true;
		}

		return false;
	}

	public static boolean isNotEmpty(Object[] array) {
		return !isEmpty(array);
	}

}