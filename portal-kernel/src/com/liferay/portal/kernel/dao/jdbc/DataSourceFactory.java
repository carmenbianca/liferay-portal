/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 */
public interface DataSourceFactory {

	public void destroyDataSource(DataSource dataSource) throws Exception;

	public DataSource initDataSource(Properties properties) throws Exception;

	public DataSource initDataSource(
			String driverClassName, String url, String userName,
			String password, String jndiName)
		throws Exception;

}