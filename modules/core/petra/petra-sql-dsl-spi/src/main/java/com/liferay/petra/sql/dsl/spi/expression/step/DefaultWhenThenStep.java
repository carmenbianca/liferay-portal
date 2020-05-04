/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.expression.step;

import com.liferay.petra.sql.dsl.expression.Expression;
import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.sql.dsl.expression.step.WhenThenStep;
import com.liferay.petra.sql.dsl.spi.expression.Scalar;

/**
 * @author Preston Crary
 */
public interface DefaultWhenThenStep<T>
	extends DefaultElseEndStep<T>, WhenThenStep<T> {

	@Override
	public default WhenThenStep<T> whenThen(
		Predicate predicate, Expression<T> expression) {

		return new WhenThen<>(this, predicate, expression);
	}

	@Override
	public default WhenThenStep<T> whenThen(Predicate predicate, T value) {
		return whenThen(predicate, new Scalar<>(value));
	}

}