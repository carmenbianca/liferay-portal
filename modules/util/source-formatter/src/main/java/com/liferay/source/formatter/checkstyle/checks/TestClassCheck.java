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
public class TestClassCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.CLASS_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		String absolutePath = getAbsolutePath();

		if (!absolutePath.contains("/test/") &&
			!absolutePath.contains("/testIntegration/")) {

			return;
		}

		DetailAST parentDetailAST = detailAST.getParent();

		if (parentDetailAST != null) {
			return;
		}

		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		String name = nameDetailAST.getText();

		if (!name.matches(".*Test(Case)?")) {
			return;
		}

		DetailAST modifiersDetailAST = detailAST.findFirstToken(
			TokenTypes.MODIFIERS);

		if (name.endsWith("TestCase")) {
			if (!modifiersDetailAST.branchContains(TokenTypes.ABSTRACT)) {
				log(
					detailAST, _MSG_INCORRECT_ABSTRACT_TEST_CASE_CLASS,
					name.substring(0, name.length() - 4));
			}
			else if (name.contains("Base") && !name.startsWith("Base")) {
				log(detailAST, _MSG_INVALID_BASE_CLASS_NAME, name);
			}
		}
		else if (modifiersDetailAST.branchContains(TokenTypes.ABSTRACT)) {
			log(detailAST, _MSG_INCORRECT_ABSTRACT_TEST_CLASS, name);
		}
	}

	private static final String _MSG_INCORRECT_ABSTRACT_TEST_CASE_CLASS =
		"test.case.class.incorrect.abstract";

	private static final String _MSG_INCORRECT_ABSTRACT_TEST_CLASS =
		"test.class.incorrect.abstract";

	private static final String _MSG_INVALID_BASE_CLASS_NAME =
		"test.base.class.invalidName";

}