/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc;

import javax.sql.DataSource;

/**
 * @author Preston Crary
 */
public interface DataSourceProvider {

	public DataSource getDataSource();

}