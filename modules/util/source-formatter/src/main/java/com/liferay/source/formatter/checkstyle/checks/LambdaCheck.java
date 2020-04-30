/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * @author Hugo Huijser
 */
public class LambdaCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.LAMBDA};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST lastChildDetailAST = detailAST.getLastChild();

		if (lastChildDetailAST.getType() != TokenTypes.SLIST) {
			return;
		}

		DetailAST firstChildDetailAST = lastChildDetailAST.getFirstChild();

		if (lastChildDetailAST.getChildCount() == 2) {
			if (firstChildDetailAST.getType() == TokenTypes.LITERAL_RETURN) {
				log(detailAST, _MSG_SIMPLIFY_LAMBDA);
			}

			return;
		}

		if ((lastChildDetailAST.getChildCount() != 3) ||
			(firstChildDetailAST.getType() != TokenTypes.EXPR)) {

			return;
		}

		DetailAST nextSiblingDetailAST = firstChildDetailAST.getNextSibling();

		if (nextSiblingDetailAST.getType() == TokenTypes.SEMI) {
			log(detailAST, _MSG_SIMPLIFY_LAMBDA);
		}
	}

	private static final String _MSG_SIMPLIFY_LAMBDA = "lambda.simplify";

}