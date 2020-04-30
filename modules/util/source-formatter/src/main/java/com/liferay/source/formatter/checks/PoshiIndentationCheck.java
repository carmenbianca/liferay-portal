/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.io.IOException;

import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class PoshiIndentationCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		StringBundler sb = new StringBundler();

		try (UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new UnsyncStringReader(content))) {

			int level = 0;
			int lineNumber = 0;

			String line = null;

			boolean insideMultiLineString = false;

			int[] multiLineCommentsPositions = SourceUtil.getMultiLinePositions(
				content, _multiLineCommentsPattern);

			while ((line = unsyncBufferedReader.readLine()) != null) {
				lineNumber++;

				if (SourceUtil.isInsideMultiLines(
						lineNumber, multiLineCommentsPositions)) {

					sb.append(line);
					sb.append("\n");

					continue;
				}

				if (!insideMultiLineString) {
					sb.append(_fixIndentation(line, level));
					sb.append("\n");

					String s = StringUtil.removeSubstrings(line, "\\");

					if (StringUtil.count(line, "'''") == 1) {
						insideMultiLineString = true;

						int x = line.indexOf("(");
						int y = line.indexOf("'''");

						if ((x != -1) && (x < y)) {
							s = StringUtil.removeSubstrings(line, "'''");

							level += getLevel(
								s, new String[] {"(", "{"},
								new String[] {")", "}"});
						}
					}
					else if (!line.matches(".*?'''[({)}]'''.*")) {
						s = s.replaceFirst("([^']*)('''.*''')([^']*)", "$1$3");

						level += getLevel(
							s, new String[] {"(", "{"},
							new String[] {")", "}"});
					}
				}
				else {
					sb.append(line);
					sb.append("\n");

					if (StringUtil.count(line, "'''") == 1) {
						insideMultiLineString = false;

						if (line.endsWith("''');")) {
							level += getLevel(
								")", new String[] {"(", "{"},
								new String[] {")", "}"});
						}
					}
				}
			}
		}

		if (sb.index() > 0) {
			sb.setIndex(sb.index() - 1);
		}

		return sb.toString();
	}

	private String _fixIndentation(String line, int level) {
		String trimmedLine = StringUtil.trim(line);

		if (Validator.isNull(trimmedLine)) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler();

		for (int i = 0; i < level; i++) {
			if ((i == (level - 1)) &&
				(trimmedLine.startsWith(")") || trimmedLine.startsWith("}"))) {

				break;
			}

			sb.append(CharPool.TAB);
		}

		sb.append(trimmedLine);

		return sb.toString();
	}

	private static final Pattern _multiLineCommentsPattern = Pattern.compile(
		"[ \t]/\\*.*?\\*/", Pattern.DOTALL);

}