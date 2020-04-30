/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class FTLIfStatementCheck extends BaseIfStatementCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		Matcher matcher = _ifStatementPattern.matcher(content);

		while (matcher.find()) {
			String ifClause = "if (" + matcher.group(2) + ") {";

			checkIfClauseParentheses(
				ifClause, fileName, getLineNumber(content, matcher.start(2)),
				true);
		}

		return content;
	}

	private static final Pattern _ifStatementPattern = Pattern.compile(
		"[\t\n]<#(else)?if ([^?\n]*)>\n");

}