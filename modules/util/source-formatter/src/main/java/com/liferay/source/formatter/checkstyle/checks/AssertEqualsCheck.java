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
public class AssertEqualsCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.METHOD_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		List<DetailAST> methodCallDetailASTList = getMethodCalls(
			detailAST, "Assert", "assertEquals");

		for (DetailAST methodCallDetailAST : methodCallDetailASTList) {
			DetailAST elistDetailAST = methodCallDetailAST.findFirstToken(
				TokenTypes.ELIST);

			List<DetailAST> exprDetailASTList = getAllChildTokens(
				elistDetailAST, false, TokenTypes.EXPR);

			if (exprDetailASTList.size() != 2) {
				continue;
			}

			DetailAST secondExprDetailAST = exprDetailASTList.get(1);

			DetailAST firstChildDetailAST = secondExprDetailAST.getFirstChild();

			String variableName = _getVariableNameForMethodCall(
				firstChildDetailAST, "getLength");

			if (variableName != null) {
				DetailAST typeDetailAST = getVariableTypeDetailAST(
					methodCallDetailAST, variableName);

				if ((typeDetailAST != null) && _isHits(typeDetailAST)) {
					log(
						methodCallDetailAST, _MSG_ASSERT_ADD_INFORMATION,
						variableName + ".toString()");
				}

				continue;
			}

			variableName = _getVariableNameForCall(
				firstChildDetailAST, "length");

			if (variableName != null) {
				DetailAST typeDetailAST = getVariableTypeDetailAST(
					methodCallDetailAST, variableName);

				if ((typeDetailAST != null) && isArray(typeDetailAST)) {
					log(
						methodCallDetailAST, _MSG_ASSERT_ADD_INFORMATION,
						"Arrays.toString(" + variableName + ")");
				}

				continue;
			}

			variableName = _getVariableNameForMethodCall(
				firstChildDetailAST, "size");

			if (variableName != null) {
				DetailAST typeDetailAST = getVariableTypeDetailAST(
					methodCallDetailAST, variableName);

				if ((typeDetailAST != null) && isCollection(typeDetailAST)) {
					log(
						methodCallDetailAST, _MSG_ASSERT_ADD_INFORMATION,
						variableName + ".toString()");
				}
			}
		}
	}

	private String _getVariableNameForCall(
		DetailAST detailAST, String methodName) {

		if (detailAST.getType() != TokenTypes.DOT) {
			return null;
		}

		List<DetailAST> nameDetailASTList = getAllChildTokens(
			detailAST, false, TokenTypes.IDENT);

		if (nameDetailASTList.size() != 2) {
			return null;
		}

		DetailAST methodNameDetailAST = nameDetailASTList.get(1);

		if (!methodName.equals(methodNameDetailAST.getText())) {
			return null;
		}

		DetailAST variableNameDetailAST = nameDetailASTList.get(0);

		return variableNameDetailAST.getText();
	}

	private String _getVariableNameForMethodCall(
		DetailAST detailAST, String methodName) {

		if (detailAST.getType() != TokenTypes.METHOD_CALL) {
			return null;
		}

		DetailAST firstChildDetailAST = detailAST.getFirstChild();

		return _getVariableNameForCall(firstChildDetailAST, methodName);
	}

	private boolean _isHits(DetailAST detailAST) {
		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		String name = nameDetailAST.getText();

		if (name.equals("Hits")) {
			return true;
		}

		return false;
	}

	private static final String _MSG_ASSERT_ADD_INFORMATION =
		"assert.add.information";

}