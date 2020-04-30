/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.portal.kernel.util.GetterUtil;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class SizeIsZeroCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.CTOR_DEF, TokenTypes.METHOD_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		List<DetailAST> methodCallDetailASTList = getMethodCalls(
			detailAST, "size");

		for (DetailAST methodCallDetailAST : methodCallDetailASTList) {
			_checkMethodCall(detailAST, methodCallDetailAST);
		}
	}

	private void _checkMethodCall(
		DetailAST detailAST, DetailAST methodCallDetailAST) {

		DetailAST nextSiblingDetailAST = methodCallDetailAST.getNextSibling();

		if ((nextSiblingDetailAST == null) ||
			(nextSiblingDetailAST.getType() != TokenTypes.NUM_INT)) {

			return;
		}

		int compareCount = GetterUtil.getInteger(
			nextSiblingDetailAST.getText());

		DetailAST parentDetailAST = methodCallDetailAST.getParent();

		if (((compareCount != 0) ||
			 ((parentDetailAST.getType() != TokenTypes.EQUAL) &&
			  (parentDetailAST.getType() != TokenTypes.NOT_EQUAL) &&
			  (parentDetailAST.getType() != TokenTypes.GT))) &&
			((compareCount != 1) ||
			 ((parentDetailAST.getType() != TokenTypes.GE) &&
			  (parentDetailAST.getType() != TokenTypes.LT)))) {

			return;
		}

		DetailAST dotDetailAST = methodCallDetailAST.getFirstChild();

		DetailAST nameDetailAST = dotDetailAST.findFirstToken(TokenTypes.IDENT);

		String variableName = nameDetailAST.getText();

		List<DetailAST> definitionDetailASTList = getAllChildTokens(
			detailAST, true, TokenTypes.PARAMETER_DEF, TokenTypes.VARIABLE_DEF);

		for (DetailAST definitionDetailAST : definitionDetailASTList) {
			DetailAST definitionNameDetailAST =
				definitionDetailAST.findFirstToken(TokenTypes.IDENT);

			if (!variableName.equals(definitionNameDetailAST.getText())) {
				continue;
			}

			DetailAST typeDetailAST = definitionDetailAST.findFirstToken(
				TokenTypes.TYPE);

			DetailAST typeNameDetailAST = typeDetailAST.findFirstToken(
				TokenTypes.IDENT);

			String typeName = typeNameDetailAST.getText();

			if (typeName.matches(".*(Collection|List|Map|Set)")) {
				log(
					methodCallDetailAST, _MSG_USE_METHOD,
					variableName + ".isEmpty()");
			}
		}
	}

	private static final String _MSG_USE_METHOD = "method.use";

}