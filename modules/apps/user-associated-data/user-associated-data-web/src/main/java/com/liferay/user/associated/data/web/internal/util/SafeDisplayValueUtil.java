/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.web.internal.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Drew Brokke
 */
public class SafeDisplayValueUtil {

	public static String get(Object unsafeValue) {
		if (unsafeValue == null) {
			return StringPool.BLANK;
		}

		String unsafeValueString = String.valueOf(unsafeValue);

		String escapedString = HtmlUtil.escape(unsafeValueString);

		return StringUtil.shorten(escapedString, 200);
	}

}