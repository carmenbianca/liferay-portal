/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class StringCastCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.CTOR_DEF, TokenTypes.METHOD_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		List<DetailAST> methodCallDetailASTList = getMethodCalls(
			detailAST, "toString");

		for (DetailAST methodCallDetailAST : methodCallDetailASTList) {
			DetailAST dotDetailAST = methodCallDetailAST.findFirstToken(
				TokenTypes.DOT);

			List<DetailAST> nameDetailASTList = getAllChildTokens(
				dotDetailAST, false, TokenTypes.IDENT);

			DetailAST variableNameDetailAST = nameDetailASTList.get(0);

			String variableTypeName = getVariableTypeName(
				methodCallDetailAST, variableNameDetailAST.getText(), false);

			if (variableTypeName.equals("String")) {
				log(methodCallDetailAST, _MSG_UNNEEDED_STRING_CAST);
			}
		}
	}

	private static final String _MSG_UNNEEDED_STRING_CAST =
		"string.cast.unneeded";

}