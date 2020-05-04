/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.factory;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;
import com.liferay.petra.sql.dsl.factory.ColumnFactory;
import com.liferay.petra.sql.dsl.spi.DefaultColumn;

/**
 * @author Preston Crary
 */
public class DefaultColumnFactory implements ColumnFactory {

	@Override
	public <T extends BaseTable<T>, C> Column<T, C> createColumn(
		T table, String name, Class<C> javaType, int sqlType, int flags) {

		return new DefaultColumn<>(table, name, javaType, sqlType, flags);
	}

}