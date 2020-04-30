/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.util.JSPSourceUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSPParenthesesCheck extends BaseIfStatementCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		Matcher matcher = _ifStatementPattern.matcher(content);

		while (matcher.find()) {
			if (JSPSourceUtil.isJavaSource(content, matcher.start())) {
				checkIfClauseParentheses(
					matcher.group(), fileName,
					getLineNumber(content, matcher.start(1)), true);
			}
		}

		matcher = _tagPattern.matcher(content);

		while (matcher.find()) {
			if (!JSPSourceUtil.isJavaSource(content, matcher.start())) {
				String ifClause = "if (" + matcher.group(1) + ") {";

				checkIfClauseParentheses(
					ifClause, fileName, getLineNumber(content, matcher.start()),
					true);
			}
		}

		return content;
	}

	private static final Pattern _ifStatementPattern = Pattern.compile(
		"[\t\n]((else )?if|while) .*\\) \\{\n");
	private static final Pattern _tagPattern = Pattern.compile("<%= (.+?) %>");

}