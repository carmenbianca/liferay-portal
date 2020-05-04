/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.jdbc.pool.metrics;

import org.apache.tomcat.jdbc.pool.DataSourceProxy;

/**
 * @author Mladen Cikara
 */
public class TomcatConnectionPoolMetrics extends BaseConnectionPoolMetrics {

	public TomcatConnectionPoolMetrics(DataSourceProxy dataSourceProxy) {
		_dataSourceProxy = dataSourceProxy;
	}

	@Override
	public int getNumActive() {
		return _dataSourceProxy.getNumActive();
	}

	@Override
	public int getNumIdle() {
		return _dataSourceProxy.getNumIdle();
	}

	@Override
	protected Object getDataSource() {
		return _dataSourceProxy;
	}

	@Override
	protected String getPoolName() {
		return _dataSourceProxy.getPoolName();
	}

	private final DataSourceProxy _dataSourceProxy;

}