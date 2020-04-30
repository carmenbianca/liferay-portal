/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter.expression;

/**
 * Represents a literal expression node in the expression tree. This expression
 * is not validated by default.
 *
 * @author Cristina González
 * @review
 */
public interface LiteralExpression extends Expression {

	/**
	 * Returns the literal expression's text value.
	 *
	 * @return the text value
	 * @review
	 */
	public String getText();

	/**
	 * Returns the literal expression's type.
	 *
	 * @return the type
	 * @review
	 */
	public Type getType();

	public static enum Type {

		BOOLEAN, DATE, DATE_TIME, DOUBLE, INTEGER, NULL, STRING

	}

}