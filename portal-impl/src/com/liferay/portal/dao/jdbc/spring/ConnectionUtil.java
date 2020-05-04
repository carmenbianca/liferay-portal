/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.jdbc.spring;

import com.liferay.portal.kernel.dao.jdbc.CurrentConnectionUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Shuyang Zhou
 */
public class ConnectionUtil {

	public static Connection getConnection(DataSource dataSource)
		throws SQLException {

		Connection connection = CurrentConnectionUtil.getConnection(dataSource);

		if (connection != null) {
			return (Connection)ProxyUtil.newProxyInstance(
				ClassLoader.getSystemClassLoader(), _INTERFACES,
				new UncloseableInvocationHandler(connection));
		}

		return dataSource.getConnection();
	}

	private static final Class<?>[] _INTERFACES = {Connection.class};

	private static final Method _closeMethod;

	static {
		try {
			_closeMethod = Connection.class.getMethod("close");
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new ExceptionInInitializerError(reflectiveOperationException);
		}
	}

	private static class UncloseableInvocationHandler
		implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

			if (method.equals(_closeMethod)) {
				return null;
			}

			return method.invoke(_connection, args);
		}

		private UncloseableInvocationHandler(Connection connection) {
			_connection = connection;
		}

		private final Connection _connection;

	}

}