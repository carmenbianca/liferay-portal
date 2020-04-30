/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Shuyang Zhou
 */
public interface ParamSetter {

	public static final ParamSetter BIGINT = new ParamSetter() {

		@Override
		public void set(PreparedStatement ps, int index, Object param)
			throws SQLException {

			ps.setLong(index, (long)param);
		}

	};

	public void set(PreparedStatement ps, int index, Object param)
		throws SQLException;

}