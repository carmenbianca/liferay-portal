/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

/**
 * @author Hugo Huijser
 */
public interface JavaExpression extends JavaTerm {

	public JavaExpression getChainedJavaExpression();

	public boolean hasSurroundingParentheses();

	public void setChainedJavaExpression(JavaExpression chainedJavaExpression);

	public void setHasSurroundingParentheses(boolean hasSurroundingParentheses);

	public void setSurroundingParentheses();

}