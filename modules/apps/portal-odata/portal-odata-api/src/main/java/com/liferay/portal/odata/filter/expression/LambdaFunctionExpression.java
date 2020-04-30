/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter.expression;

/**
 * Represents a lambda function expression in the expression tree
 *
 * @author Rubén Pulido
 * @review
 */
public interface LambdaFunctionExpression extends Expression {

	/**
	 * Returns the child expression
	 *
	 * @return The child expression
	 * @review
	 */
	public Expression getExpression();

	/**
	 * Returns the type of the lambda function expression
	 *
	 * @return The type
	 * @review
	 */
	public Type getType();

	/**
	 * @return The name of the lambda variable
	 * @review
	 */
	public String getVariableName();

	public static enum Type {

		ANY

	}

}