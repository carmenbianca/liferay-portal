/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

/**
 * @author Hugo Huijser
 */
public class JSONIndentationCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		int expectedTabCount = 0;

		StringBundler sb = new StringBundler();

		try (UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new UnsyncStringReader(content))) {

			String line = null;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				sb.append(_fixIndentation(line, expectedTabCount));

				sb.append("\n");

				expectedTabCount = getLevel(
					line,
					new String[] {
						StringPool.OPEN_BRACKET, StringPool.OPEN_CURLY_BRACE
					},
					new String[] {
						StringPool.CLOSE_BRACKET, StringPool.CLOSE_CURLY_BRACE
					},
					expectedTabCount);
			}
		}

		String newContent = StringUtil.trimTrailing(sb.toString());

		if (fileName.endsWith("/package.json") &&
			newContent.equals(StringUtil.trimTrailing(content))) {

			return content;
		}

		return newContent;
	}

	private String _fixIndentation(String line, int expectedTabCount) {
		if (Validator.isNull(line)) {
			return line;
		}

		int leadingTabCount = getLeadingTabCount(line);

		if (line.matches("\t*[\\}\\]].*")) {
			expectedTabCount -= 1;
		}

		if (leadingTabCount == expectedTabCount) {
			return line;
		}

		String expectedTab = new String(new char[expectedTabCount]);

		return StringUtil.replace(expectedTab, "\0", "\t") +
			StringUtil.trimLeading(line);
	}

}