/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shuyang Zhou
 */
public class PrimaryKeyRowMapper implements RowMapper<Long> {

	@Override
	public Long mapRow(ResultSet rs) throws SQLException {
		return rs.getLong(1);
	}

}