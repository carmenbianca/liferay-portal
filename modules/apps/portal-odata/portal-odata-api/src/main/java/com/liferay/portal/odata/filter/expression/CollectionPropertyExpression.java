/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter.expression;

/**
 * Models a collection {@code PropertyExpression}.
 *
 * @author Rubén Pulido
 * @review
 */
public interface CollectionPropertyExpression extends PropertyExpression {

	/**
	 * Gets the lambda function expression.
	 *
	 * @return the lambda function expression
	 * @review
	 */
	public LambdaFunctionExpression getLambdaFunctionExpression();

	/**
	 * Gets the property expression.
	 *
	 * @return the property expression
	 * @review
	 */
	public PropertyExpression getPropertyExpression();

}