/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaElseStatement extends BaseJavaTerm {

	public void setJavaIfStatement(JavaIfStatement javaIfStatement) {
		_javaIfStatement = javaIfStatement;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		if (_javaIfStatement == null) {
			return StringBundler.concat(indent, prefix, "else", suffix);
		}

		return _javaIfStatement.toString(
			indent, "else ", suffix, maxLineLength);
	}

	private JavaIfStatement _javaIfStatement;

}