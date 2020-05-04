/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression.model;

/**
 * @author Marcellus Tavares
 */
public abstract class ExpressionVisitor<T> {

	public T visit(AndExpression andExpression) {
		return null;
	}

	public T visit(ArithmeticExpression arithmeticExpression) {
		return null;
	}

	public T visit(ArrayExpression arrayExpression) {
		return null;
	}

	public T visit(ComparisonExpression comparisonExpression) {
		return null;
	}

	public T visit(FloatingPointLiteral floatingPointLiteral) {
		return null;
	}

	public T visit(FunctionCallExpression functionCallExpression) {
		return null;
	}

	public T visit(IntegerLiteral integerLiteral) {
		return null;
	}

	public T visit(MinusExpression minusExpression) {
		return null;
	}

	public T visit(NotExpression notExpression) {
		return null;
	}

	public T visit(OrExpression orExpression) {
		return null;
	}

	public T visit(Parenthesis parenthesis) {
		return null;
	}

	public T visit(StringLiteral stringLiteral) {
		return null;
	}

	public T visit(Term term) {
		return null;
	}

}