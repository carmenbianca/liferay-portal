/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.db;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mariano Álvaro Sáiz
 */
public class DBTypeToSQLMap {

	public DBTypeToSQLMap(String defaultSQL) {
		_defaultSQL = defaultSQL;
	}

	public void add(DBType dbType, String sql) {
		_sqls.put(dbType, sql);
	}

	public String get(DBType dbType) {
		String sql = _sqls.get(dbType);

		if (sql != null) {
			return sql;
		}

		return _defaultSQL;
	}

	private final String _defaultSQL;
	private final Map<DBType, String> _sqls = new HashMap<>();

}