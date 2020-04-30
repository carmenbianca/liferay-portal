/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.factory;

import com.liferay.petra.sql.dsl.Table;
import com.liferay.petra.sql.dsl.expression.Expression;
import com.liferay.petra.sql.dsl.query.FromStep;

/**
 * @author Preston Crary
 */
public interface DSLQueryFactory {

	public FromStep count();

	public FromStep countDistinct(Expression<?> expression);

	public FromStep select();

	public FromStep select(Expression<?>... expressions);

	public <T extends Table<T>> FromStep select(Table<T> table);

	public FromStep selectDistinct(Expression<?>... expressions);

	public <T extends Table<T>> FromStep selectDistinct(T table);

}