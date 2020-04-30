/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaTernaryOperator extends BaseJavaExpression {

	public JavaTernaryOperator(
		JavaExpression conditionJavaExpression,
		JavaExpression trueValueJavaExpression,
		JavaExpression falseValueJavaExpression) {

		_conditionJavaExpression = conditionJavaExpression;
		_trueValueJavaExpression = trueValueJavaExpression;
		_falseValueJavaExpression = falseValueJavaExpression;
	}

	@Override
	public boolean hasSurroundingParentheses() {
		if (getChainedJavaExpression() != null) {
			return true;
		}

		return super.hasSurroundingParentheses();
	}

	@Override
	protected String getString(
		String indent, String prefix, String suffix, int maxLineLength,
		boolean forceLineBreak) {

		StringBundler sb = new StringBundler();

		sb.append(indent);

		indent = "\t" + indent;

		indent = append(
			sb, _conditionJavaExpression, indent, prefix, " ? ", maxLineLength);

		indent = append(
			sb, _trueValueJavaExpression, indent, "", " : ", maxLineLength);

		append(
			sb, _falseValueJavaExpression, indent, "", suffix, maxLineLength);

		return sb.toString();
	}

	private final JavaExpression _conditionJavaExpression;
	private final JavaExpression _falseValueJavaExpression;
	private final JavaExpression _trueValueJavaExpression;

}