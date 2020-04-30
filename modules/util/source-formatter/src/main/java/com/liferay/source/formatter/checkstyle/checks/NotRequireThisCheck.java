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
public class NotRequireThisCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.CTOR_DEF, TokenTypes.METHOD_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		List<DetailAST> thisDetailASTList = getAllChildTokens(
			detailAST, true, TokenTypes.LITERAL_THIS);

		outerLoop:
		for (DetailAST thisDetailAST : thisDetailASTList) {
			if (_isMethodCall(thisDetailAST) ||
				(thisDetailAST.getPreviousSibling() != null)) {

				continue;
			}

			DetailAST parentDetailAST = thisDetailAST.getParent();

			if (parentDetailAST.getType() != TokenTypes.DOT) {
				continue;
			}

			DetailAST nameDetailAST = parentDetailAST.findFirstToken(
				TokenTypes.IDENT);

			String name = nameDetailAST.getText();

			List<DetailAST> definitionDetailASTList = getAllChildTokens(
				detailAST, true, TokenTypes.PARAMETER_DEF,
				TokenTypes.VARIABLE_DEF);

			for (DetailAST definitionDetailAST : definitionDetailASTList) {
				DetailAST definitionNameDetailAST =
					definitionDetailAST.findFirstToken(TokenTypes.IDENT);

				if (name.equals(definitionNameDetailAST.getText())) {
					continue outerLoop;
				}
			}

			log(thisDetailAST, _MSG_VARIABLE_THIS_NOT_REQUIRED, name);
		}
	}

	private boolean _isMethodCall(DetailAST detailAST) {
		DetailAST parentDetailAST = detailAST.getParent();

		while (true) {
			if (parentDetailAST.getType() == TokenTypes.METHOD_CALL) {
				return true;
			}

			if (parentDetailAST.getType() != TokenTypes.DOT) {
				return false;
			}

			parentDetailAST = parentDetailAST.getParent();
		}
	}

	private static final String _MSG_VARIABLE_THIS_NOT_REQUIRED =
		"variable.not.require.this";

}