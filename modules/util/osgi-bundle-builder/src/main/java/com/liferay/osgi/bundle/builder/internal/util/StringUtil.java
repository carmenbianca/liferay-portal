/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.bundle.builder.internal.util;

/**
 * @author Andrea Di Giorgi
 */
public class StringUtil {

	public static String join(Iterable<String> strings, char separator) {
		StringBuilder sb = new StringBuilder();

		boolean first = true;

		for (String s : strings) {
			if (!first) {
				sb.append(separator);
			}
			else {
				first = false;
			}

			sb.append(s);
		}

		return sb.toString();
	}

}