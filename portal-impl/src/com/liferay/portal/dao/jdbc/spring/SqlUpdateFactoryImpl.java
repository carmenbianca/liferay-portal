/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.jdbc.spring;

import com.liferay.portal.kernel.dao.jdbc.ParamSetter;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactory;

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 */
public class SqlUpdateFactoryImpl implements SqlUpdateFactory {

	@Override
	public SqlUpdate getSqlUpdate(
		DataSource dataSource, String sql, ParamSetter... paramSetters) {

		return new SqlUpdateImpl(dataSource, sql, paramSetters);
	}

}