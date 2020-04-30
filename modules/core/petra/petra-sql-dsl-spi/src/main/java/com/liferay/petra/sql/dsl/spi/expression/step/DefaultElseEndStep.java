/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.expression.step;

import com.liferay.petra.sql.dsl.expression.Expression;
import com.liferay.petra.sql.dsl.expression.step.ElseEndStep;
import com.liferay.petra.sql.dsl.spi.expression.Scalar;

/**
 * @author Preston Crary
 */
public interface DefaultElseEndStep<T> extends ElseEndStep<T> {

	@Override
	public default Expression<T> elseEnd(Expression<T> expression) {
		return new ElseEnd<>(this, expression);
	}

	@Override
	public default Expression<T> elseEnd(T value) {
		return elseEnd(new Scalar<>(value));
	}

}