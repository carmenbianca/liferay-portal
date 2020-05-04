/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.query;

import com.liferay.petra.sql.dsl.Table;
import com.liferay.petra.sql.dsl.query.sort.OrderByExpression;
import com.liferay.petra.sql.dsl.query.sort.OrderByInfo;

import java.util.function.Function;

/**
 * @author Preston Crary
 */
public interface OrderByStep extends LimitStep {

	public default LimitStep orderBy(
		Function<OrderByStep, LimitStep> function) {

		LimitStep limitStep = function.apply(this);

		if (limitStep == null) {
			return this;
		}

		return limitStep;
	}

	public LimitStep orderBy(OrderByExpression... orderByExpressions);

	public LimitStep orderBy(Table<?> table, OrderByInfo orderByInfo);

}