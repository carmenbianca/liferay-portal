/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.internal.filter.expression;

import com.liferay.portal.odata.filter.expression.CollectionPropertyExpression;
import com.liferay.portal.odata.filter.expression.ExpressionVisitException;
import com.liferay.portal.odata.filter.expression.ExpressionVisitor;
import com.liferay.portal.odata.filter.expression.LambdaFunctionExpression;
import com.liferay.portal.odata.filter.expression.PropertyExpression;

/**
 * @author Rubén Pulido
 */
public class CollectionPropertyExpressionImpl
	implements CollectionPropertyExpression {

	public CollectionPropertyExpressionImpl(
		PropertyExpression propertyExpression,
		LambdaFunctionExpression lambdaFunctionExpression) {

		_propertyExpression = propertyExpression;
		_lambdaFunctionExpression = lambdaFunctionExpression;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> expressionVisitor)
		throws ExpressionVisitException {

		return expressionVisitor.visitCollectionPropertyExpression(this);
	}

	@Override
	public LambdaFunctionExpression getLambdaFunctionExpression() {
		return _lambdaFunctionExpression;
	}

	@Override
	public String getName() {
		return _propertyExpression.getName();
	}

	@Override
	public PropertyExpression getPropertyExpression() {
		return _propertyExpression;
	}

	@Override
	public String toString() {
		String string = _propertyExpression.toString();

		return string.concat(
			"/"
		).concat(
			_lambdaFunctionExpression.toString()
		);
	}

	private final LambdaFunctionExpression _lambdaFunctionExpression;
	private final PropertyExpression _propertyExpression;

}