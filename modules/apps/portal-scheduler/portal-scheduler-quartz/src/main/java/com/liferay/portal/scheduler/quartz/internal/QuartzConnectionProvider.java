/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.scheduler.quartz.internal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;

import java.sql.Connection;

import javax.sql.DataSource;

import org.quartz.utils.ConnectionProvider;

/**
 * @author Bruno Farache
 */
public class QuartzConnectionProvider implements ConnectionProvider {

	@Override
	public Connection getConnection() {
		Connection con = null;

		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();

			con = dataSource.getConnection();
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		return con;
	}

	@Override
	public void shutdown() {
	}

	private static final Log _log = LogFactoryUtil.getLog(
		QuartzConnectionProvider.class);

}