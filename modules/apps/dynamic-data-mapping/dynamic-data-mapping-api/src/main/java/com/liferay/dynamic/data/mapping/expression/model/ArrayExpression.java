/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression.model;

/**
 * @author Rafael Praxedes
 */
public class ArrayExpression extends Term {

	public ArrayExpression(String arrayLiteral) {
		super(arrayLiteral);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> expressionVisitor) {
		return expressionVisitor.visit(this);
	}

}