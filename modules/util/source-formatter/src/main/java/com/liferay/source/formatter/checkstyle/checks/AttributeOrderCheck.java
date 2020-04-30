/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.List;

/**
 * @author Alan Huang
 */
public class AttributeOrderCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.INSTANCE_INIT};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST parentDetailAST = detailAST.getParent();

		if (parentDetailAST.getType() != TokenTypes.OBJBLOCK) {
			return;
		}

		parentDetailAST = parentDetailAST.getParent();

		if (parentDetailAST.getType() != TokenTypes.LITERAL_NEW) {
			return;
		}

		DetailAST childDetailAST = detailAST.getFirstChild();

		if (childDetailAST.getType() != TokenTypes.SLIST) {
			return;
		}

		List<DetailAST> exprDetailASTList = getAllChildTokens(
			childDetailAST, false, TokenTypes.EXPR);

		if (exprDetailASTList.size() < 2) {
			return;
		}

		_checkAttributeOrder(exprDetailASTList);
	}

	private void _checkAttributeOrder(List<DetailAST> exprDetailASTList) {
		String previousName = null;

		for (DetailAST exprDetailAST : exprDetailASTList) {
			DetailAST childDetailAST = exprDetailAST.getFirstChild();

			if (childDetailAST.getType() != TokenTypes.ASSIGN) {
				continue;
			}

			DetailAST nameDetailAST = childDetailAST.findFirstToken(
				TokenTypes.IDENT);

			String name = nameDetailAST.getText();

			if ((previousName != null) &&
				(previousName.compareToIgnoreCase(name) > 0)) {

				log(
					exprDetailAST, _MSG_ATTRIBUTE_INCORRECT_ORDER, previousName,
					name);
			}

			previousName = name;
		}
	}

	private static final String _MSG_ATTRIBUTE_INCORRECT_ORDER =
		"attribute.incorrect.order";

}