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
public class UnwrappedVariableInfoCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.VARIABLE_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		String absolutePath = getAbsolutePath();

		if (!absolutePath.endsWith("Tei.java")) {
			return;
		}

		String line = getLine(detailAST.getLineNo() - 1);

		if (!line.contains("private static final VariableInfo[]")) {
			return;
		}

		DetailAST parentDetailAST = detailAST.getParent();

		while (true) {
			if (parentDetailAST == null) {
				return;
			}

			if (parentDetailAST.getType() == TokenTypes.CLASS_DEF) {
				DetailAST nameDetailAST = parentDetailAST.findFirstToken(
					TokenTypes.IDENT);

				String className = nameDetailAST.getText();

				if (className.equals("Concealer")) {
					return;
				}

				break;
			}

			parentDetailAST = parentDetailAST.getParent();
		}

		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		log(detailAST, _MSG_UNWRAPPED_VARIABLE_INFO, nameDetailAST.getText());
	}

	private static final String _MSG_UNWRAPPED_VARIABLE_INFO =
		"variable.info.unwrapped";

}