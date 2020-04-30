/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TextFormatter;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.utils.AnnotationUtil;

/**
 * @author Hugo Huijser
 */
public class CamelCaseNameCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {
			TokenTypes.METHOD_DEF, TokenTypes.PARAMETER_DEF,
			TokenTypes.VARIABLE_DEF
		};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		_checkName(detailAST, "re", "reCaptcha");
		_checkName(detailAST, "sub");
	}

	private void _checkName(
		DetailAST detailAST, String s, String... allowedNames) {

		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		String name = nameDetailAST.getText();

		String lowerCaseName = StringUtil.toLowerCase(name);

		for (String allowedName : allowedNames) {
			if (lowerCaseName.contains(StringUtil.toLowerCase(allowedName))) {
				return;
			}
		}

		if (detailAST.getType() == TokenTypes.METHOD_DEF) {
			if (!AnnotationUtil.containsAnnotation(detailAST, "Override")) {
				String regex = StringBundler.concat(
					"(^_", s, "|.*", TextFormatter.format(s, TextFormatter.G),
					")[A-Z].*");

				if (name.matches(regex)) {
					log(detailAST, _MSG_METHOD_INVALID_NAME, s, name);
				}
			}
		}
		else {
			String regex = StringBundler.concat("^_?", s, "[A-Z].*");

			if (name.matches(regex)) {
				if (detailAST.getType() == TokenTypes.PARAMETER_DEF) {
					log(detailAST, _MSG_PARAMETER_INVALID_NAME, s, name);
				}
				else {
					log(detailAST, _MSG_VARIABLE_INVALID_NAME, s, name);
				}
			}
		}
	}

	private static final String _MSG_METHOD_INVALID_NAME = "method.invalidName";

	private static final String _MSG_PARAMETER_INVALID_NAME =
		"parameter.invalidName";

	private static final String _MSG_VARIABLE_INVALID_NAME =
		"variable.invalidName";

}