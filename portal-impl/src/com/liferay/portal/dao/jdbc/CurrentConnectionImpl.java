/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.jdbc;

import com.liferay.portal.kernel.dao.jdbc.CurrentConnection;
import com.liferay.portal.spring.hibernate.SpringHibernateThreadLocalUtil;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.ConnectionHolder;

/**
 * @author Shuyang Zhou
 */
public class CurrentConnectionImpl implements CurrentConnection {

	@Override
	public Connection getConnection(DataSource dataSource) {
		ConnectionHolder connectionHolder =
			(ConnectionHolder)SpringHibernateThreadLocalUtil.getResource(
				dataSource);

		if ((connectionHolder == null) ||
			(connectionHolder.getConnectionHandle() == null)) {

			return null;
		}

		return connectionHolder.getConnection();
	}

}