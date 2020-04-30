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
public class StringBundlerNamingCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.PARAMETER_DEF, TokenTypes.VARIABLE_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		String typeName = getTypeName(detailAST, false);

		if (!typeName.equals("StringBundler")) {
			return;
		}

		DetailAST modifiersDetailAST = detailAST.findFirstToken(
			TokenTypes.MODIFIERS);

		if (modifiersDetailAST.branchContains(TokenTypes.LITERAL_PROTECTED) ||
			modifiersDetailAST.branchContains(TokenTypes.LITERAL_PUBLIC)) {

			return;
		}

		String name = _getName(detailAST);

		if (!name.matches("_?(sb|.*SB)([0-9]*)?")) {
			log(
				detailAST, _MSG_INCORRECT_VARIABLE_NAME,
				_getTokenTypeName(detailAST), name);
		}
	}

	private String _getName(DetailAST detailAST) {
		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		return nameDetailAST.getText();
	}

	private String _getTokenTypeName(DetailAST detailAST) {
		if (detailAST.getType() == TokenTypes.PARAMETER_DEF) {
			return "parameter";
		}

		return "variable";
	}

	private static final String _MSG_INCORRECT_VARIABLE_NAME =
		"variable.name.incorrect";

}