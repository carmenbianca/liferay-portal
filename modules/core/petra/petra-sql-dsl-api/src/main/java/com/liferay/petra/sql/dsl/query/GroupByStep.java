/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.query;

import com.liferay.petra.sql.dsl.expression.Expression;

/**
 * @author Preston Crary
 */
public interface GroupByStep extends OrderByStep {

	public HavingStep groupBy(Expression<?>... expressions);

}