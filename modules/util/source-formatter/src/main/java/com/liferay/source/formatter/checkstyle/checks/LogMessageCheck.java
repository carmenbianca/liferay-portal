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
public class LogMessageCheck extends BaseMessageCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.CTOR_DEF, TokenTypes.METHOD_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		_checkMethod(detailAST, "_log", "debug");
		_checkMethod(detailAST, "_log", "error");
		_checkMethod(detailAST, "_log", "info");
		_checkMethod(detailAST, "_log", "trace");
		_checkMethod(detailAST, "_log", "warn");
	}

	private void _checkMethod(
		DetailAST detailAST, String variableName, String methodName) {

		List<DetailAST> methodCallDetailASTList = getMethodCalls(
			detailAST, variableName, methodName);

		for (DetailAST methodCallDetailAST : methodCallDetailASTList) {
			DetailAST elistDetailAST = methodCallDetailAST.findFirstToken(
				TokenTypes.ELIST);

			List<DetailAST> exprDetailASTList = getAllChildTokens(
				elistDetailAST, false, TokenTypes.EXPR);

			for (DetailAST exprDetailAST : exprDetailASTList) {
				checkMessage(
					getLiteralStringValue(exprDetailAST),
					exprDetailAST.getLineNo());
			}
		}
	}

}