/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.query;

import com.liferay.petra.sql.dsl.Table;
import com.liferay.petra.sql.dsl.expression.Predicate;

/**
 * @author Preston Crary
 */
public interface JoinStep extends WhereStep {

	public JoinStep innerJoinON(Table<?> table, Predicate predicate);

	public JoinStep leftJoinOn(Table<?> table, Predicate predicate);

}