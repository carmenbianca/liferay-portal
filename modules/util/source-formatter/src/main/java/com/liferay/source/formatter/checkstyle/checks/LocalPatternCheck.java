/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.utils.ScopeUtil;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class LocalPatternCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.VARIABLE_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		if (!ScopeUtil.isLocalVariableDef(detailAST)) {
			return;
		}

		List<DetailAST> methodCallDetailASTList = getMethodCalls(
			detailAST, "Pattern", "compile");

		if (methodCallDetailASTList.isEmpty()) {
			return;
		}

		DetailAST methodCallDetailAST = methodCallDetailASTList.get(0);

		DetailAST elistDetailAST = methodCallDetailAST.findFirstToken(
			TokenTypes.ELIST);

		DetailAST expressionDetailAST = elistDetailAST.findFirstToken(
			TokenTypes.EXPR);

		List<DetailAST> childDetailASTList = getAllChildTokens(
			expressionDetailAST, true, ALL_TYPES);

		for (DetailAST childDetailAST : childDetailASTList) {
			if ((childDetailAST.getType() != TokenTypes.PLUS) &&
				(childDetailAST.getType() != TokenTypes.STRING_LITERAL)) {

				return;
			}
		}

		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		log(detailAST, _MSG_LOCAL_PATTERN, nameDetailAST.getText());
	}

	private static final String _MSG_LOCAL_PATTERN = "pattern.local";

}