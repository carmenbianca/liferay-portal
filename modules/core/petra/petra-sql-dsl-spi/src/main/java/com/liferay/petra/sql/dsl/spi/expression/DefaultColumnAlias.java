/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.expression;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.Table;
import com.liferay.petra.sql.dsl.expression.ColumnAlias;

/**
 * @author Preston Crary
 */
public class DefaultColumnAlias<T extends Table<T>, C>
	extends DefaultAlias<C> implements ColumnAlias<T, C> {

	public DefaultColumnAlias(Column<T, C> column, String name) {
		super(column, name);

		_table = column.getTable();
	}

	@Override
	public T getTable() {
		return _table;
	}

	private final T _table;

}