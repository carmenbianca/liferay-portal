/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.test.util;

/**
 * @author Adam Brandizzi
 */
public interface UpgradeDatabaseTestHelper extends AutoCloseable {

	public void dropColumn(
			String tableClassName, String tableName, String columnName)
		throws Exception;

	public boolean hasColumn(String tableName, String columnName)
		throws Exception;

}