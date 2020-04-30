/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class CSSEmptyLinesCheck extends BaseEmptyLinesCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		content = fixMissingEmptyLinesAroundComments(content);

		return _fixEmptyLines(content);
	}

	private String _fixEmptyLines(String content) {
		Matcher matcher = _emptyLineAfterOpenCurlyBrace.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "\n\n", "\n", matcher.start());
		}

		matcher = _emptyLineBeforeCloseCurlyBrace.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "\n\n", "\n", matcher.start());
		}

		matcher = _missingEmptyLineAfterComment.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "\n", "\n\n", matcher.start());
		}

		matcher = _missingEmptyLineBeforeComment.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "\n", "\n\n", matcher.start());
		}

		return content;
	}

	private static final Pattern _emptyLineAfterOpenCurlyBrace =
		Pattern.compile("\\{\n\n\t*(?!(/\\* --|//))\\S");
	private static final Pattern _emptyLineBeforeCloseCurlyBrace =
		Pattern.compile("\n\n\t*\\}");
	private static final Pattern _missingEmptyLineAfterComment =
		Pattern.compile("-- \\*/\n.");
	private static final Pattern _missingEmptyLineBeforeComment =
		Pattern.compile(".\n\t*/\\* --");

}