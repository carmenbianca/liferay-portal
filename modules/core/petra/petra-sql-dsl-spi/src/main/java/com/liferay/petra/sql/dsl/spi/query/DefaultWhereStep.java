/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.query;

import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.sql.dsl.query.GroupByStep;
import com.liferay.petra.sql.dsl.query.WhereStep;

/**
 * @author Preston Crary
 */
public interface DefaultWhereStep extends DefaultGroupByStep, WhereStep {

	@Override
	public default GroupByStep where(Predicate predicate) {
		if (predicate == null) {
			return this;
		}

		return new Where(this, predicate);
	}

}