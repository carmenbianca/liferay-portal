/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.search.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Mirco Tamburini
 * @author Josiah Goh
 */
public class KeywordsUtil {

	public static final String[] SPECIAL = {
		"+", "-", "&&", "||", "!", "(", ")", "{", "}", "[", "]", "^", "\"", "~",
		"*", "?", ":", "\\"
	};

	public static String escape(String text) {
		for (int i = SPECIAL.length - 1; i >= 0; i--) {
			text = StringUtil.replace(
				text, SPECIAL[i], StringPool.BACK_SLASH + SPECIAL[i]);
		}

		return text;
	}

	public static String toFuzzy(String keywords) {
		if (keywords == null) {
			return null;
		}

		if (!keywords.endsWith(StringPool.TILDE)) {
			keywords = keywords + StringPool.TILDE;
		}

		return keywords;
	}

	public static String toWildcard(String keywords) {
		if (keywords == null) {
			return null;
		}

		if (!keywords.endsWith(StringPool.STAR)) {
			keywords = keywords + StringPool.STAR;
		}

		return keywords;
	}

}