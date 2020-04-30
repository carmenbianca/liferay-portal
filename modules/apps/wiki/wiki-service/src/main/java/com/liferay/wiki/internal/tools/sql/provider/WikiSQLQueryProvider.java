/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.internal.tools.sql.provider;

import com.liferay.portal.tools.sql.SQLQueryProvider;

import java.io.InputStream;

/**
 * @author Miguel Pastor
 */
public class WikiSQLQueryProvider implements SQLQueryProvider {

	@Override
	public InputStream getIndexesSQL() {
		return getInputStream("META-INF/sql/indexes.sql");
	}

	@Override
	public InputStream getTablesSQL() {
		return getInputStream("META-INF/sql/tables.sql");
	}

	protected InputStream getInputStream(String path) {
		Class<?> clazz = getClass();

		ClassLoader classLoader = clazz.getClassLoader();

		return classLoader.getResourceAsStream(path);
	}

}