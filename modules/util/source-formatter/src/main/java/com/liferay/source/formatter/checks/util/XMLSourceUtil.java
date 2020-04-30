/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks.util;

/**
 * @author Hugo Huijser
 */
public class XMLSourceUtil {

	public static boolean isInsideCDATAMarkup(String content, int pos) {
		String s = content.substring(pos);

		int x = s.indexOf("]]>");

		if (x == -1) {
			return false;
		}

		s = s.substring(0, x);

		if (!s.contains("<![CDATA[")) {
			return true;
		}

		return false;
	}

}