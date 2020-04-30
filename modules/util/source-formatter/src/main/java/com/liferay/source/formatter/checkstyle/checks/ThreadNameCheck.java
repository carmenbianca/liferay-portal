/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.source.formatter.checks.util.SourceUtil;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class ThreadNameCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.LITERAL_NEW};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST firstChildDetailAST = detailAST.getFirstChild();

		if ((firstChildDetailAST == null) ||
			(firstChildDetailAST.getType() != TokenTypes.IDENT) ||
			!Objects.equals(firstChildDetailAST.getText(), "Thread")) {

			return;
		}

		DetailAST elistDetailAST = detailAST.findFirstToken(TokenTypes.ELIST);

		if (elistDetailAST == null) {
			return;
		}

		List<DetailAST> exprDetailASTList = getAllChildTokens(
			elistDetailAST, false, TokenTypes.EXPR);

		for (DetailAST exprDetailAST : exprDetailASTList) {
			firstChildDetailAST = exprDetailAST.getFirstChild();

			if (firstChildDetailAST.getType() != TokenTypes.STRING_LITERAL) {
				continue;
			}

			String name = firstChildDetailAST.getText();

			name = name.substring(1, name.length() - 1);

			Matcher matcher = _camelCasePattern.matcher(name);

			String expectedName = SourceUtil.getTitleCase(
				matcher.replaceAll("$1 $2"), false);

			if (!name.equals(expectedName)) {
				log(firstChildDetailAST, _MSG_RENAME_THREAD, expectedName);
			}
		}
	}

	private static final String _MSG_RENAME_THREAD = "thread.rename";

	private static final Pattern _camelCasePattern = Pattern.compile(
		"([a-z])([A-Z])");

}