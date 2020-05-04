/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

/**
 * @author Shuyang Zhou
 */
public class CurrentConnectionUtil {

	public static Connection getConnection(DataSource dataSource) {
		return getCurrentConnection().getConnection(dataSource);
	}

	public static CurrentConnection getCurrentConnection() {
		return _currentConnection;
	}

	public void setCurrentConnection(CurrentConnection currentConnection) {
		_currentConnection = currentConnection;
	}

	private static CurrentConnection _currentConnection;

}