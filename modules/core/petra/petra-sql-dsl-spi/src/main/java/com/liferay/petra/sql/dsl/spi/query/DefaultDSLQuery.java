/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.query;

import com.liferay.petra.sql.dsl.Table;
import com.liferay.petra.sql.dsl.query.DSLQuery;

/**
 * @author Preston Crary
 */
public interface DefaultDSLQuery extends DSLQuery {

	@Override
	public default Table<?> as(String name) {
		return new QueryTable(name, this);
	}

	@Override
	public default DSLQuery union(DSLQuery dslQuery) {
		return new SetOperation(this, SetOperationType.UNION, dslQuery);
	}

	@Override
	public default DSLQuery unionAll(DSLQuery dslQuery) {
		return new SetOperation(this, SetOperationType.UNION_ALL, dslQuery);
	}

}