/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.sample.sql.builder;

import com.liferay.portal.dao.db.MySQLDB;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * A simplified version of MySQLDB for sample SQL generation. This should not be
 * used for any other purposes.
 *
 * @author Shuyang Zhou
 */
public class SampleMySQLDB extends MySQLDB {

	public SampleMySQLDB(int majorVersion, int minorVersion) {
		super(majorVersion, minorVersion);
	}

	@Override
	public String buildSQL(String template) {
		return StringUtil.replace(template, _GENERIC_TEMPLATE, _MYSQL_TEMPLATE);
	}

	private static final String[] _GENERIC_TEMPLATE = {
		"TRUE", "FALSE", "'01/01/1970'", "CURRENT_TIMESTAMP",
		"COMMIT_TRANSACTION"
	};

	private static final String[] _MYSQL_TEMPLATE = {
		"1", "0", "'1970-01-01'", "now()", "commit"
	};

}