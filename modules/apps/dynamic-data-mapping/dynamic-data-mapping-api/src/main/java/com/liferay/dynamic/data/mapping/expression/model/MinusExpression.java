/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression.model;

/**
 * @author Leonardo Barros
 */
public class MinusExpression extends UnaryExpression {

	public MinusExpression(Expression operandExpression) {
		super(operandExpression);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> expressionVisitor) {
		return expressionVisitor.visit(this);
	}

	@Override
	public String toString() {
		return String.format("-%s", getOperandExpression());
	}

}