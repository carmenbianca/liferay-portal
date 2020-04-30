/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.portal.kernel.util.StringUtil;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * @author Hugo Huijser
 */
public class LineBreakBeforeGenericStartCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.GENERIC_START};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		if (isAtLineStart(
				detailAST, getLine(getStartLineNumber(detailAST) - 1))) {

			return;
		}

		DetailAST nextSiblingDetailAST = detailAST.getNextSibling();

		while (true) {
			if (nextSiblingDetailAST == null) {
				return;
			}

			if (nextSiblingDetailAST.getType() != TokenTypes.GENERIC_END) {
				nextSiblingDetailAST = nextSiblingDetailAST.getNextSibling();

				continue;
			}

			if (detailAST.getLineNo() == nextSiblingDetailAST.getLineNo()) {
				return;
			}

			String line = getLine(detailAST.getLineNo() - 1);

			String s = StringUtil.trim(
				line.substring(0, detailAST.getColumnNo()));

			log(detailAST, _MSG_INCORRECT_LINE_BREAK, s);

			return;
		}
	}

	private static final String _MSG_INCORRECT_LINE_BREAK =
		"line.break.incorrect";

}