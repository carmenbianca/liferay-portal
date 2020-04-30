/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * @author Hugo Huijser
 */
public class LineEndCharacterCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {
			TokenTypes.GENERIC_START, TokenTypes.LPAREN, TokenTypes.TYPECAST
		};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		if (detailAST.getType() == TokenTypes.LPAREN) {
			DetailAST parentDetailAST = detailAST.getParent();

			if ((parentDetailAST.getType() == TokenTypes.ANNOTATION) ||
				(parentDetailAST.getType() == TokenTypes.CTOR_CALL) ||
				(parentDetailAST.getType() == TokenTypes.CTOR_DEF) ||
				(parentDetailAST.getType() == TokenTypes.ENUM_CONSTANT_DEF) ||
				(parentDetailAST.getType() == TokenTypes.LAMBDA) ||
				(parentDetailAST.getType() == TokenTypes.LITERAL_CATCH) ||
				(parentDetailAST.getType() == TokenTypes.LITERAL_NEW) ||
				(parentDetailAST.getType() == TokenTypes.METHOD_DEF) ||
				(parentDetailAST.getType() == TokenTypes.SUPER_CTOR_CALL)) {

				return;
			}
		}

		if (isAtLineEnd(detailAST, getLine(detailAST.getLineNo() - 1))) {
			log(
				detailAST, _MSG_INCORRECT_END_LINE_CHARACTER,
				detailAST.getText());
		}
	}

	private static final String _MSG_INCORRECT_END_LINE_CHARACTER =
		"end.line.character.incorrect";

}