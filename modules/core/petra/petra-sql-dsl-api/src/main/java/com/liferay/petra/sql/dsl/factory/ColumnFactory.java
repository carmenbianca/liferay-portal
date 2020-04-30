/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.factory;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

/**
 * @author Preston Crary
 */
public interface ColumnFactory {

	public <T extends BaseTable<T>, C> Column<T, C> createColumn(
		T table, String name, Class<C> javaType, int sqlType, int flags);

}