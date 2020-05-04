/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaIfStatement extends BaseJavaTerm {

	public JavaIfStatement(JavaExpression conditionJavaExpression) {
		_conditionJavaExpression = conditionJavaExpression;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		StringBundler sb = new StringBundler();

		sb.append(indent);

		indent = "\t" + indent;

		append(
			sb, _conditionJavaExpression, indent, prefix + "if (", ")" + suffix,
			maxLineLength);

		return sb.toString();
	}

	private final JavaExpression _conditionJavaExpression;

}