/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaWhileStatement extends BaseJavaLoopStatement {

	public JavaWhileStatement(JavaExpression conditionJavaExpression) {
		_conditionJavaExpression = conditionJavaExpression;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		StringBundler sb = appendLabelName(indent);

		appendNewLine(
			sb, _conditionJavaExpression, indent, "while (", ")" + suffix,
			maxLineLength);

		return sb.toString();
	}

	private final JavaExpression _conditionJavaExpression;

}