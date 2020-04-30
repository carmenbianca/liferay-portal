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
public class UnnecessaryVariableDeclarationCheck
	extends BaseUnnecessaryStatementCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.VARIABLE_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		DetailAST modifiersDetailAST = detailAST.findFirstToken(
			TokenTypes.MODIFIERS);

		if (modifiersDetailAST.branchContains(TokenTypes.ANNOTATION)) {
			return;
		}

		DetailAST semiDetailAST = detailAST.getNextSibling();

		if ((semiDetailAST == null) ||
			(semiDetailAST.getType() != TokenTypes.SEMI)) {

			return;
		}

		String variableName = nameDetailAST.getText();

		checkUnnecessaryStatementBeforeReturn(
			detailAST, semiDetailAST, variableName,
			_MSG_UNNECESSARY_VARIABLE_DECLARATION_BEFORE_RETURN);

		DetailAST parentDetailAST = detailAST.getParent();

		if (parentDetailAST.getType() != TokenTypes.SLIST) {
			return;
		}

		List<DetailAST> variableCallerDetailASTList =
			getVariableCallerDetailASTList(detailAST, variableName);

		if (variableCallerDetailASTList.isEmpty()) {
			return;
		}

		DetailAST firstVariableCallerDetailAST =
			variableCallerDetailASTList.get(0);

		DetailAST secondVariableCallerDetailAST = null;

		if (variableCallerDetailASTList.size() > 1) {
			secondVariableCallerDetailAST = variableCallerDetailASTList.get(1);
		}

		checkUnnecessaryStatementBeforeReassign(
			detailAST, firstVariableCallerDetailAST,
			secondVariableCallerDetailAST, parentDetailAST, variableName,
			_MSG_UNNECESSARY_VARIABLE_DECLARATION_BEFORE_REASSIGN);
	}

	private static final String
		_MSG_UNNECESSARY_VARIABLE_DECLARATION_BEFORE_REASSIGN =
			"variable.declaration.unnecessary.before.reassign";

	private static final String
		_MSG_UNNECESSARY_VARIABLE_DECLARATION_BEFORE_RETURN =
			"variable.declaration.unnecessary.before.return";

}