/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class MarkdownStylingCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		content = _formatCodeSyntax(content);

		return _formatHeaders(content);
	}

	private String _formatCodeSyntax(String content) {
		Matcher matcher = _incorrectCodeSyntaxPattern.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "```", "`", matcher.start());
		}

		return content;
	}

	private String _formatHeaders(String content) {
		Matcher matcher = _incorrectHeaderNotationPattern.matcher(content);

		content = matcher.replaceAll("$1$2$4");

		matcher = _boldHeaderPattern.matcher(content);

		return matcher.replaceAll("$1$2$4$6");
	}

	private static final Pattern _boldHeaderPattern = Pattern.compile(
		"(\\A|\n)(#+ ?)(\\*+)([^\\*\n]+)(\\*+)(\n)");
	private static final Pattern _incorrectCodeSyntaxPattern = Pattern.compile(
		"\\S.*```|```.* ");
	private static final Pattern _incorrectHeaderNotationPattern =
		Pattern.compile("(\\A|\n)(#+[^#\n]+)(#+)(\n)");

}