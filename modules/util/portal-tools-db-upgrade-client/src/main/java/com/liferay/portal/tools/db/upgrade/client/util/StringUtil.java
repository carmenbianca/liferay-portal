/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.db.upgrade.client.util;

/**
 * @author Andrea Di Giorgi
 */
public class StringUtil {

	public static String join(Iterable<?> objects, char separator) {
		StringBuilder sb = new StringBuilder();

		int i = 0;

		for (Object object : objects) {
			if (i > 0) {
				sb.append(separator);
			}

			sb.append(object);

			i++;
		}

		return sb.toString();
	}

}