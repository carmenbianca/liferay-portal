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
public class AnnotationParameterOrderCheck extends BaseCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.ANNOTATION};
	}

	@Override
	protected void doVisitToken(DetailAST detailAST) {
		List<DetailAST> annotationMemberValuePairDetailASTList =
			getAllChildTokens(
				detailAST, false, TokenTypes.ANNOTATION_MEMBER_VALUE_PAIR);

		String previousName = null;

		for (DetailAST annotationMemberValuePairDetailAST :
				annotationMemberValuePairDetailASTList) {

			DetailAST nameDetailAST =
				annotationMemberValuePairDetailAST.findFirstToken(
					TokenTypes.IDENT);

			String name = nameDetailAST.getText();

			if ((previousName != null) &&
				(previousName.compareToIgnoreCase(name) > 0)) {

				log(
					annotationMemberValuePairDetailAST,
					_MSG_UNSORTED_ANNOTATION_PARAMETER, name);
			}

			previousName = name;
		}
	}

	private static final String _MSG_UNSORTED_ANNOTATION_PARAMETER =
		"annotation.unsortedParameter";

}