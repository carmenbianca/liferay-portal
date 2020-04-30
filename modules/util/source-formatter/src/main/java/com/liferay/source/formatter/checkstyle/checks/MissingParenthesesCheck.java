/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.portal.kernel.util.ArrayUtil;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * @author Hugo Huijser
 */
public class MissingParenthesesCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return ArrayUtil.append(
			_CONDITIONAL_OPERATOR_TOKEN_TYPES, TokenTypes.QUESTION);
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST firstChildDetailAST = detailAST.getFirstChild();

		if (detailAST.getType() == TokenTypes.QUESTION) {
			if (ArrayUtil.contains(
					_RELATIONAL_OPERATOR_TOKEN_TYPES,
					firstChildDetailAST.getType())) {

				log(
					firstChildDetailAST.getFirstChild(),
					_MSG_MISSING_PARENTHESES_2, "left", detailAST.getText());
			}

			return;
		}

		if ((firstChildDetailAST.getType() != detailAST.getType()) &&
			ArrayUtil.contains(
				_CONDITIONAL_OPERATOR_TOKEN_TYPES,
				firstChildDetailAST.getType())) {

			log(
				firstChildDetailAST.getFirstChild(), _MSG_MISSING_PARENTHESES_1,
				firstChildDetailAST.getText(), detailAST.getText());
		}

		if (ArrayUtil.contains(
				_RELATIONAL_OPERATOR_TOKEN_TYPES,
				firstChildDetailAST.getType())) {

			log(
				firstChildDetailAST.getFirstChild(), _MSG_MISSING_PARENTHESES_2,
				"left", detailAST.getText());
		}

		DetailAST lastChildDetailAST = detailAST.getLastChild();

		if (ArrayUtil.contains(
				_RELATIONAL_OPERATOR_TOKEN_TYPES,
				lastChildDetailAST.getType())) {

			log(
				lastChildDetailAST.getFirstChild(), _MSG_MISSING_PARENTHESES_2,
				"right", detailAST.getText());
		}
	}

	private static final int[] _CONDITIONAL_OPERATOR_TOKEN_TYPES = {
		TokenTypes.BAND, TokenTypes.BOR, TokenTypes.BXOR, TokenTypes.LAND,
		TokenTypes.LOR
	};

	private static final String _MSG_MISSING_PARENTHESES_1 =
		"parentheses.missing.1";

	private static final String _MSG_MISSING_PARENTHESES_2 =
		"parentheses.missing.2";

	private static final int[] _RELATIONAL_OPERATOR_TOKEN_TYPES = {
		TokenTypes.EQUAL, TokenTypes.GE, TokenTypes.GT, TokenTypes.LE,
		TokenTypes.LT, TokenTypes.NOT_EQUAL
	};

}