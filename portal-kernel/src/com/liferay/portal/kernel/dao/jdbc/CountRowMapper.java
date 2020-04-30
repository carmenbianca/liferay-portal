/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.ResultSet;

/**
 * @author Brian Wing Shun Chan
 */
public class CountRowMapper implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet rs) {
		return 1;
	}

}