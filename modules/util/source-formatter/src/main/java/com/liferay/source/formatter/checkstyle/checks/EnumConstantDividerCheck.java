/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import com.puppycrawl.tools.checkstyle.api.DetailAST;

/**
 * @author Hugo Huijser
 */
public class EnumConstantDividerCheck extends BaseEnumConstantCheck {

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST nextEnumConstantDefinitionDetailAST =
			getNextEnumConstantDefinitionDetailAST(detailAST);

		if (nextEnumConstantDefinitionDetailAST != null) {
			_checkDivider(detailAST, nextEnumConstantDefinitionDetailAST);
		}
	}

	private void _checkDivider(
		DetailAST enumConstantDefinitionDetailAST1,
		DetailAST enumConstantDefinitionDetailAST2) {

		int endLineNumberConstant1 = getEndLineNumber(
			enumConstantDefinitionDetailAST1);
		int startLineNumberConstant2 = getStartLineNumber(
			enumConstantDefinitionDetailAST2);

		if (endLineNumberConstant1 == startLineNumberConstant2) {
			return;
		}

		String nextLine = getLine(endLineNumberConstant1);
		String nextNextLine = StringUtil.trim(
			getLine(endLineNumberConstant1 + 1));

		if (Validator.isNull(nextLine) && !nextNextLine.startsWith("/")) {
			log(endLineNumberConstant1 + 1, _MSG_UNNECESSARY_EMPTY_LINE);
		}
	}

	private static final String _MSG_UNNECESSARY_EMPTY_LINE =
		"empty.line.unnecessary";

}