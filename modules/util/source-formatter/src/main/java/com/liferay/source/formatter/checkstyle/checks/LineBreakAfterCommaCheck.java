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
public class LineBreakAfterCommaCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.COMMA};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		String line = getLine(detailAST.getLineNo() - 1);

		if (isAtLineEnd(detailAST, line)) {
			return;
		}

		int lineNo = detailAST.getLineNo();

		if ((lineNo != getStartLineNumber(detailAST.getPreviousSibling())) ||
			(lineNo != getEndLineNumber(detailAST.getNextSibling()))) {

			String s = StringUtil.trim(
				line.substring(0, detailAST.getColumnNo() + 1));

			log(lineNo, _MSG_INCORRECT_LINE_BREAK, s);
		}
	}

	private static final String _MSG_INCORRECT_LINE_BREAK =
		"line.break.incorrect";

}