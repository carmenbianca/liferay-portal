/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

/**
 * @author Shuyang Zhou
 */
public interface CurrentConnection {

	public Connection getConnection(DataSource dataSource);

}