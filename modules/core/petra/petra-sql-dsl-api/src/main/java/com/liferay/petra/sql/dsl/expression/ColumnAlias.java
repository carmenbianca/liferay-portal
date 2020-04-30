/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.expression;

import com.liferay.petra.sql.dsl.Table;

/**
 * @author Preston Crary
 */
public interface ColumnAlias<T extends Table<T>, C> extends Alias<C> {

	public T getTable();

}