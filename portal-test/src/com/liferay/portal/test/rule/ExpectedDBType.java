/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.test.rule;

import com.liferay.portal.kernel.dao.db.DBType;

/**
 * @author Shuyang Zhou
 */
public enum ExpectedDBType {

	DB2(DBType.DB2), HYPERSONIC(DBType.HYPERSONIC), MARIADB(DBType.MARIADB),
	MYSQL(DBType.MYSQL), NONE(null), ORACLE(DBType.ORACLE),
	POSTGRESQL(DBType.POSTGRESQL), SQLSERVER(DBType.SQLSERVER),
	SYBASE(DBType.SYBASE);

	public DBType getDBType() {
		return _dbType;
	}

	private ExpectedDBType(DBType dbType) {
		_dbType = dbType;
	}

	private final DBType _dbType;

}