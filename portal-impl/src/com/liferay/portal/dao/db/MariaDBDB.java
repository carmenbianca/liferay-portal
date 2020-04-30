/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.db;

import com.liferay.portal.kernel.dao.db.DBType;

/**
 * @author Preston Crary
 */
public class MariaDBDB extends MySQLDB {

	public MariaDBDB(int majorVersion, int minorVersion) {
		super(DBType.MARIADB, majorVersion, minorVersion);
	}

}