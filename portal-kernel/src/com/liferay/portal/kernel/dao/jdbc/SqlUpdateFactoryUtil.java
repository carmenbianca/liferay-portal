/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 */
public class SqlUpdateFactoryUtil {

	public static SqlUpdate getSqlUpdate(
		DataSource dataSource, String sql, ParamSetter... paramSetters) {

		return getSqlUpdateFactory().getSqlUpdate(
			dataSource, sql, paramSetters);
	}

	public static SqlUpdateFactory getSqlUpdateFactory() {
		return _sqlUpdateFactory;
	}

	public void setSqlUpdateFactory(SqlUpdateFactory sqlUpdateFactory) {
		_sqlUpdateFactory = sqlUpdateFactory;
	}

	private static SqlUpdateFactory _sqlUpdateFactory;

}