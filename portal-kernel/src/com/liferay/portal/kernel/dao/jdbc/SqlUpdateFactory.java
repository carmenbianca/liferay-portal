/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 */
public interface SqlUpdateFactory {

	public SqlUpdate getSqlUpdate(
		DataSource dataSource, String sql, ParamSetter... paramSetters);

}