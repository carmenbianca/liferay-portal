/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.db;

/**
 * @author Shuyang Zhou
 */
public interface DBFactory {

	public DB create(int dbMajorVersion, int dbMinorVersion);

	public DBType getDBType();

}