/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.lang.builder.internal.util;

import com.liferay.gradle.util.GradleUtil;
import com.liferay.gradle.util.Validator;

/**
 * @author Andrea Di Giorgi
 */
public class StringUtil extends com.liferay.gradle.util.StringUtil {

	public static String merge(Iterable<?> iterable, String separator) {
		StringBuilder sb = new StringBuilder();

		boolean first = true;

		for (Object object : iterable) {
			if (!first) {
				sb.append(separator);
			}

			first = false;

			String s = GradleUtil.toString(object);

			if (Validator.isNotNull(s)) {
				sb.append(s);
			}
		}

		return sb.toString();
	}

}