/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * @author Hugo Huijser
 */
public class WhitespaceAfterParameterAnnotationCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.PARAMETER_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST modifiersDetailAST = detailAST.findFirstToken(
			TokenTypes.MODIFIERS);

		if (modifiersDetailAST == null) {
			return;
		}

		DetailAST annotationDetailAST = modifiersDetailAST.findFirstToken(
			TokenTypes.ANNOTATION);

		if (annotationDetailAST == null) {
			return;
		}

		DetailAST rparenDetailAST = annotationDetailAST.findFirstToken(
			TokenTypes.RPAREN);

		if (rparenDetailAST == null) {
			return;
		}

		String line = getLine(rparenDetailAST.getLineNo() - 1);

		if ((rparenDetailAST.getColumnNo() + 1) >= line.length()) {
			return;
		}

		char c = line.charAt(rparenDetailAST.getColumnNo() + 1);

		if (!Character.isWhitespace(c)) {
			log(
				rparenDetailAST, _MSG_MISSING_WHITESPACE,
				rparenDetailAST.getText());
		}
	}

	private static final String _MSG_MISSING_WHITESPACE = "whitespace.missing";

}