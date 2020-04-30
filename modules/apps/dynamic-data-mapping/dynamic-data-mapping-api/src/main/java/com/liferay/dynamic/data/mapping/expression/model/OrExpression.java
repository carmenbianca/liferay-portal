/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression.model;

/**
 * @author Leonardo Barros
 */
public class OrExpression extends BinaryExpression {

	public OrExpression(
		Expression leftOperandExpression, Expression rightOperandExpression) {

		super("or", leftOperandExpression, rightOperandExpression);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> expressionVisitor) {
		return expressionVisitor.visit(this);
	}

}