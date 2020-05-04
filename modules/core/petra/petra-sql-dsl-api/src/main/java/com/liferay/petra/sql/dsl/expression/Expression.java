/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.expression;

import com.liferay.petra.sql.dsl.ast.ASTNode;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.petra.sql.dsl.query.sort.OrderByExpression;

/**
 * @author Preston Crary
 */
public interface Expression<T> extends ASTNode {

	public Alias<T> as(String name);

	public OrderByExpression ascending();

	public OrderByExpression descending();

	public Predicate eq(Expression<T> expression);

	public Predicate eq(T value);

	public Predicate gt(Expression<T> expression);

	public Predicate gt(T value);

	public Predicate gte(Expression<T> expression);

	public Predicate gte(T value);

	public Predicate in(DSLQuery dslQuery);

	public Predicate in(T[] values);

	public Predicate isNotNull();

	public Predicate isNull();

	public Predicate like(Expression<String> expression);

	public Predicate like(String value);

	public Predicate lt(Expression<T> expression);

	public Predicate lt(T value);

	public Predicate lte(Expression<T> expression);

	public Predicate lte(T value);

	public Predicate neq(Expression<T> expression);

	public Predicate neq(T value);

	public Predicate notIn(DSLQuery dslQuery);

	public Predicate notIn(T[] values);

	public Predicate notLike(Expression<String> expression);

	public Predicate notLike(String value);

}