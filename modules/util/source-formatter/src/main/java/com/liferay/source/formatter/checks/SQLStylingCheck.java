/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Hugo Huijser
 */
public class SQLStylingCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		for (String line : StringUtil.splitLines(content)) {
			String strippedQuotesLine = stripQuotes(line, CharPool.APOSTROPHE);

			if (strippedQuotesLine.contains(StringPool.QUOTE)) {
				String newLine = StringUtil.replace(
					line, CharPool.QUOTE, CharPool.APOSTROPHE);

				return StringUtil.replace(content, line, newLine);
			}
		}

		return content;
	}

}