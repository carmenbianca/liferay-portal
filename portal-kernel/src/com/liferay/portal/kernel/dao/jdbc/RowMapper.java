/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Brian Wing Shun Chan
 */
public interface RowMapper<T> {

	public static final RowMapper<Integer> COUNT = new CountRowMapper();

	public static final RowMapper<Long> PRIMARY_KEY = new PrimaryKeyRowMapper();

	public T mapRow(ResultSet rs) throws SQLException;

}