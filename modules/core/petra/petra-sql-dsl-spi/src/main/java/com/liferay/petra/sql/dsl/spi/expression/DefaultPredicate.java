/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.expression;

import com.liferay.petra.sql.dsl.ast.ASTNodeListener;
import com.liferay.petra.sql.dsl.expression.Expression;
import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.sql.dsl.spi.ast.BaseASTNode;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Preston Crary
 */
public class DefaultPredicate
	extends BaseASTNode implements DefaultExpression<Boolean>, Predicate {

	public DefaultPredicate(
		Expression<?> leftExpression, Operand operand,
		Expression<?> rightExpression) {

		this(leftExpression, operand, rightExpression, false);
	}

	@Override
	public Predicate and(Expression<Boolean> expression) {
		if (expression == null) {
			return this;
		}

		return new DefaultPredicate(this, Operand.AND, expression);
	}

	public Expression<?> getLeftExpression() {
		return _leftExpression;
	}

	public Operand getOperand() {
		return _operand;
	}

	public Expression<?> getRightExpression() {
		return _rightExpression;
	}

	public boolean isWrapParentheses() {
		return _wrapParentheses;
	}

	@Override
	public Predicate or(Expression<Boolean> expression) {
		if (expression == null) {
			return this;
		}

		return new DefaultPredicate(this, Operand.OR, expression);
	}

	@Override
	public Predicate withParentheses() {
		if (_wrapParentheses) {
			return this;
		}

		return new DefaultPredicate(
			_leftExpression, _operand, _rightExpression, true);
	}

	@Override
	protected void doToSQL(
		Consumer<String> consumer, ASTNodeListener astNodeListener) {

		if (_wrapParentheses) {
			consumer.accept("(");
		}

		_leftExpression.toSQL(consumer, astNodeListener);

		consumer.accept(_operand.getStringWithSpaces());

		_rightExpression.toSQL(consumer, astNodeListener);

		if (_wrapParentheses) {
			consumer.accept(")");
		}
	}

	private DefaultPredicate(
		Expression<?> leftExpression, Operand operand,
		Expression<?> rightExpression, boolean wrapParentheses) {

		_leftExpression = Objects.requireNonNull(leftExpression);
		_operand = Objects.requireNonNull(operand);
		_rightExpression = Objects.requireNonNull(rightExpression);
		_wrapParentheses = wrapParentheses;
	}

	private final Expression<?> _leftExpression;
	private final Operand _operand;
	private final Expression<?> _rightExpression;
	private final boolean _wrapParentheses;

}