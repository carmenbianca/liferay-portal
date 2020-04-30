/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.sql;

import java.io.InputStream;

/**
 * @author Miguel Pastor
 */
public interface SQLQueryProvider {

	public InputStream getIndexesSQL();

	public InputStream getTablesSQL();

}