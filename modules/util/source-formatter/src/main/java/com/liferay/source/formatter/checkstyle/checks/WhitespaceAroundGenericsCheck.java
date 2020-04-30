/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.petra.string.CharPool;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * @author Hugo Huijser
 */
public class WhitespaceAroundGenericsCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.GENERIC_END, TokenTypes.GENERIC_START};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		if (!hasParentWithTokenType(detailAST, TokenTypes.TYPE)) {
			return;
		}

		String line = getLine(detailAST.getLineNo() - 1);

		if (detailAST.getType() == TokenTypes.GENERIC_END) {
			if ((detailAST.getColumnNo() + 1) >= line.length()) {
				return;
			}

			char c = line.charAt(detailAST.getColumnNo() + 1);

			if ((c != CharPool.CLOSE_PARENTHESIS) && (c != CharPool.COMMA) &&
				(c != CharPool.PERIOD) && (c != CharPool.GREATER_THAN) &&
				(c != CharPool.OPEN_BRACKET) && (c != CharPool.SPACE)) {

				log(detailAST, _MSG_MISSING_WHITESPACE, detailAST.getText());
			}
		}
		else if (!isAtLineStart(detailAST, line)) {
			char c = line.charAt(detailAST.getColumnNo() - 1);

			if (c == CharPool.SPACE) {
				log(detailAST, _MSG_REDUNDANT_WHITESPACE, detailAST.getText());
			}
		}
	}

	private static final String _MSG_MISSING_WHITESPACE = "whitespace.missing";

	private static final String _MSG_REDUNDANT_WHITESPACE =
		"whitespace.redundant";

}