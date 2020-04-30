/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

/**
 * @author Hugo Huijser
 */
public class JavaThrowStatement extends BaseJavaTerm {

	public JavaThrowStatement(JavaExpression throwJavaExpression) {
		_throwJavaExpression = throwJavaExpression;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		return _throwJavaExpression.toString(
			indent, prefix + "throw ", suffix, maxLineLength);
	}

	private final JavaExpression _throwJavaExpression;

}