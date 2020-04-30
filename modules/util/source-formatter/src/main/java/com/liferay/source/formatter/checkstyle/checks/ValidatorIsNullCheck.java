/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class ValidatorIsNullCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.CTOR_DEF, TokenTypes.METHOD_DEF};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		_checkMethod(detailAST, "Validator", "isNotNull");
		_checkMethod(detailAST, "Validator", "isNull");
	}

	private void _checkMethod(
		DetailAST detailAST, String className, String methodName) {

		List<DetailAST> methodCallDetailASTList = getMethodCalls(
			detailAST, className, methodName);

		for (DetailAST methodCallDetailAST : methodCallDetailASTList) {
			DetailAST elistDetailAST = methodCallDetailAST.findFirstToken(
				TokenTypes.ELIST);

			DetailAST expressionDetailAST = elistDetailAST.findFirstToken(
				TokenTypes.EXPR);

			DetailAST childDetailAST = expressionDetailAST.getFirstChild();

			if (childDetailAST.getType() == TokenTypes.NUM_INT) {
				log(
					methodCallDetailAST, _MSG_INVALID_METHOD_NAME,
					StringBundler.concat(className, ".", methodName, "(long)"));

				continue;
			}

			if (childDetailAST.getType() != TokenTypes.IDENT) {
				continue;
			}

			DetailAST typeDetailAST = getVariableTypeDetailAST(
				methodCallDetailAST, childDetailAST.getText());

			if (typeDetailAST == null) {
				continue;
			}

			childDetailAST = typeDetailAST.getFirstChild();

			if ((childDetailAST != null) &&
				((childDetailAST.getType() == TokenTypes.LITERAL_INT) ||
				 (childDetailAST.getType() == TokenTypes.LITERAL_LONG))) {

				log(
					methodCallDetailAST, _MSG_INVALID_METHOD_NAME,
					StringBundler.concat(className, ".", methodName, "(long)"));

				continue;
			}

			String typeName = getTypeName(typeDetailAST, true);

			if (Validator.isNotNull(typeName) && !typeName.equals("Long") &&
				!typeName.equals("Object") &&
				!typeName.equals("Serializable") &&
				!typeName.equals("String")) {

				log(
					methodCallDetailAST, _MSG_RESERVED_METHOD,
					StringBundler.concat(className, ".", methodName));
			}
		}
	}

	private static final String _MSG_INVALID_METHOD_NAME = "method.invalidName";

	private static final String _MSG_RESERVED_METHOD = "method.reserved";

}