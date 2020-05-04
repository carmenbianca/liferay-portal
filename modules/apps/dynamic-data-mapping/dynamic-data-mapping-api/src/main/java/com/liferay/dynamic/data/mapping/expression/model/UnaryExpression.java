/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression.model;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Leonardo Barros
 */
@ProviderType
public abstract class UnaryExpression extends Expression {

	public UnaryExpression(Expression operandExpression) {
		_operandExpression = operandExpression;
	}

	public Expression getOperandExpression() {
		return _operandExpression;
	}

	private final Expression _operandExpression;

}