/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 */
public class DataSourceFactoryUtil {

	public static void destroyDataSource(DataSource dataSource)
		throws Exception {

		getDataSourceFactory().destroyDataSource(dataSource);
	}

	public static DataSourceFactory getDataSourceFactory() {
		return _dataSourceFactory;
	}

	public static DataSource initDataSource(Properties properties)
		throws Exception {

		return getDataSourceFactory().initDataSource(properties);
	}

	public static DataSource initDataSource(
			String driverClassName, String url, String userName,
			String password, String jndiName)
		throws Exception {

		return getDataSourceFactory().initDataSource(
			driverClassName, url, userName, password, jndiName);
	}

	public static void setDataSourceFactory(
		DataSourceFactory dataSourceFactory) {

		_dataSourceFactory = dataSourceFactory;
	}

	private static DataSourceFactory _dataSourceFactory;

}