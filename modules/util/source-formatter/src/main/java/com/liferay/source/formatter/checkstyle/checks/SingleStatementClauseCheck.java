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
public class SingleStatementClauseCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {
			TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_IF,
			TokenTypes.LITERAL_WHILE
		};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST lastChildDetailAST = detailAST.getLastChild();

		if (lastChildDetailAST.getType() == TokenTypes.SEMI) {
			log(detailAST, _MSG_MISSING_BRACES, detailAST.getText());
		}
	}

	private static final String _MSG_MISSING_BRACES = "braces.missing";

}