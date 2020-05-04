/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.db;

import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public interface DBManager {

	public DB getDB();

	public DB getDB(DBType dbType, DataSource dataSource);

	public DBType getDBType(Object dialect);

	public Set<DBType> getDBTypes();

	public void setDB(DB db);

}