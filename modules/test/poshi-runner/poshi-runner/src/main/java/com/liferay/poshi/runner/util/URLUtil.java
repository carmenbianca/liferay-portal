/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.util;

import java.net.URLEncoder;

/**
 * @author Kenji Heigel
 */
public class URLUtil {

	public static String encode(String s, String encoding) throws Exception {
		return URLEncoder.encode(s, encoding);
	}

	public static String encodeUTF8(String s) throws Exception {
		return encode(s, "UTF-8");
	}

}