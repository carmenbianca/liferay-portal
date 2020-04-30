/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.util;

import java.util.Arrays;

/**
 * @author Andrea Di Giorgi
 */
public class StringUtil {

	public static String capitalize(String s) {
		char firstChar = s.charAt(0);

		if (Character.isLowerCase(firstChar)) {
			s = Character.toUpperCase(firstChar) + s.substring(1);
		}

		return s;
	}

	public static String merge(String[] array, String separator) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);

			if ((i + 1) < array.length) {
				sb.append(separator);
			}
		}

		return sb.toString();
	}

	public static String[] prepend(String[] array, String prefix) {
		if (ArrayUtil.isEmpty(array) || Validator.isNull(prefix)) {
			return array;
		}

		String[] newArray = new String[array.length];

		for (int i = 0; i < array.length; i++) {
			newArray[i] = prefix + array[i];
		}

		return newArray;
	}

	public static String repeat(char c, int length) {
		char[] chars = new char[length];

		Arrays.fill(chars, c);

		return new String(chars);
	}

}