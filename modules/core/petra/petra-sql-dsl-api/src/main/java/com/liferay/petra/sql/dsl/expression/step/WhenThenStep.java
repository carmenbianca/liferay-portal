/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.expression.step;

import com.liferay.petra.sql.dsl.expression.Expression;
import com.liferay.petra.sql.dsl.expression.Predicate;

/**
 * @author Preston Crary
 */
public interface WhenThenStep<T> extends ElseEndStep<T> {

	public WhenThenStep<T> whenThen(
		Predicate predicate, Expression<T> expression);

	public WhenThenStep<T> whenThen(Predicate predicate, T value);

}