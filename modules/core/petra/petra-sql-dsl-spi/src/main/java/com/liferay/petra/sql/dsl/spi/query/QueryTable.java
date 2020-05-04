/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.query;

import com.liferay.petra.sql.dsl.ast.ASTNodeListener;
import com.liferay.petra.sql.dsl.base.BaseTable;
import com.liferay.petra.sql.dsl.query.DSLQuery;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Shuyang Zhou
 */
public class QueryTable extends BaseTable<QueryTable> {

	public QueryTable(String name, DSLQuery dslQuery) {
		super(null, () -> new QueryTable(name, dslQuery));

		setAlias(Objects.requireNonNull(name));

		_dslQuery = Objects.requireNonNull(dslQuery);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return System.identityHashCode(this);
	}

	@Override
	public void toSQL(
		Consumer<String> consumer, ASTNodeListener astNodeListener) {

		if (astNodeListener != null) {
			astNodeListener.process(this);
		}

		consumer.accept("(");

		_dslQuery.toSQL(consumer, astNodeListener);

		consumer.accept(") ");

		consumer.accept(getName());
	}

	private final DSLQuery _dslQuery;

}