/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.expression;

/**
 * @author Preston Crary
 */
public interface Predicate extends Expression<Boolean> {

	public Predicate and(Expression<Boolean> expression);

	public Predicate or(Expression<Boolean> expression);

	public Predicate withParentheses();

}