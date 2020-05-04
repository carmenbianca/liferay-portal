/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaReturnStatement extends BaseJavaTerm {

	public JavaExpression getReturnJavaExpression() {
		return _returnJavaExpression;
	}

	public void setReturnJavaExpression(JavaExpression returnJavaExpression) {
		_returnJavaExpression = returnJavaExpression;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		if (_returnJavaExpression == null) {
			return StringBundler.concat(indent, prefix, "return", suffix);
		}

		return _returnJavaExpression.toString(
			indent, prefix + "return ", suffix, maxLineLength);
	}

	private JavaExpression _returnJavaExpression;

}