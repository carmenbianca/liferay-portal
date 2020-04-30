/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter.expression;

/**
 * Represents a lambda variable expression in the expression tree
 *
 * @author Rubén Pulido
 * @review
 */
public interface LambdaVariableExpression extends Expression {

	/**
	 * Returns the name of the lambda variable
	 *
	 * @return The name of the lambda variable
	 * @review
	 */
	public String getVariableName();

}