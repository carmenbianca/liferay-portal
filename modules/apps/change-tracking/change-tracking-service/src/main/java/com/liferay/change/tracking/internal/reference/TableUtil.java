/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.reference;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.Table;

import java.util.Objects;

/**
 * @author Preston Crary
 */
public class TableUtil {

	@SuppressWarnings("unchecked")
	public static <T extends Table<T>> Column<T, Long> getPrimaryKeyColumn(
		Table<T> table) {

		for (Column<T, ?> column : table.getColumns()) {
			if (column.isPrimaryKey() &&
				!Objects.equals(column.getName(), "ctCollectionId") &&
				Long.class.isAssignableFrom(column.getJavaType())) {

				return (Column<T, Long>)column;
			}
		}

		return null;
	}

}