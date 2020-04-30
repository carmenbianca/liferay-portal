/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class UnusedParameterCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {
			TokenTypes.CLASS_DEF, TokenTypes.ENUM_DEF, TokenTypes.INTERFACE_DEF
		};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		DetailAST parentDetailAST = detailAST.getParent();

		if (parentDetailAST != null) {
			return;
		}

		List<DetailAST> constructorsAndMethodsASTList = getAllChildTokens(
			detailAST, true, TokenTypes.CTOR_DEF, TokenTypes.METHOD_DEF);

		for (DetailAST constructorOrMethodDetailAST :
				constructorsAndMethodsASTList) {

			_checkUnusedParameters(detailAST, constructorOrMethodDetailAST);
		}
	}

	private void _checkUnusedParameters(
		DetailAST classDetailAST, DetailAST detailAST) {

		DetailAST modifiersDetailAST = detailAST.findFirstToken(
			TokenTypes.MODIFIERS);

		if (!modifiersDetailAST.branchContains(TokenTypes.LITERAL_PRIVATE)) {
			return;
		}

		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		String name = nameDetailAST.getText();

		if (name.equals("readObject") || name.equals("writeObject")) {
			return;
		}

		List<String> parameterNames = getParameterNames(detailAST);

		if (parameterNames.isEmpty()) {
			return;
		}

		DetailAST statementsDetailAST = detailAST.findFirstToken(
			TokenTypes.SLIST);

		List<DetailAST> allIdentsAST = getAllChildTokens(
			statementsDetailAST, true, TokenTypes.IDENT);

		parameterNameLoop:
		for (String parameterName : getParameterNames(detailAST)) {
			for (DetailAST identDetailAST : allIdentsAST) {
				if (parameterName.equals(identDetailAST.getText())) {
					continue parameterNameLoop;
				}
			}

			if (!_isReferencedMethod(classDetailAST, detailAST)) {
				log(detailAST, _MSG_UNUSED_PARAMETER, parameterName);
			}
		}
	}

	private boolean _isReferencedMethod(
		DetailAST classDetailAST, DetailAST detailAST) {

		List<DetailAST> methodReferenceDetailASTList = getAllChildTokens(
			classDetailAST, true, TokenTypes.METHOD_REF);

		if (methodReferenceDetailASTList.isEmpty()) {
			return false;
		}

		DetailAST nameDetailAST = detailAST.findFirstToken(TokenTypes.IDENT);

		String name = nameDetailAST.getText();

		for (DetailAST methodReferenceDetailAST :
				methodReferenceDetailASTList) {

			for (DetailAST identDetailAST :
					getAllChildTokens(
						methodReferenceDetailAST, true, TokenTypes.IDENT)) {

				if (name.equals(identDetailAST.getText())) {
					return true;
				}
			}
		}

		return false;
	}

	private static final String _MSG_UNUSED_PARAMETER = "parameter.unused";

}