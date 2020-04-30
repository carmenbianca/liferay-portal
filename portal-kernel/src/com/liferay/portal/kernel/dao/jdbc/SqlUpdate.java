/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.SQLException;

/**
 * @author Brian Wing Shun Chan
 */
public interface SqlUpdate {

	public int update(Object... params) throws SQLException;

}