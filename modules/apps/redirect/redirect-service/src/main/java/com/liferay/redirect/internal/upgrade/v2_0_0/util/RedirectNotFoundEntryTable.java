/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.internal.upgrade.v2_0_0.util;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class RedirectNotFoundEntryTable {

	public static final String TABLE_NAME = "RedirectNotFoundEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT},
		{"redirectNotFoundEntryId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"hits", Types.BIGINT},
		{"ignored", Types.BOOLEAN}, {"url", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
new HashMap<String, Integer>();

static {
TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);

TABLE_COLUMNS_MAP.put("redirectNotFoundEntryId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("hits", Types.BIGINT);

TABLE_COLUMNS_MAP.put("ignored", Types.BOOLEAN);

TABLE_COLUMNS_MAP.put("url", Types.VARCHAR);

}
	public static final String TABLE_SQL_CREATE =
"create table RedirectNotFoundEntry (mvccVersion LONG default 0 not null,redirectNotFoundEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,hits LONG,ignored BOOLEAN,url STRING null)";

	public static final String TABLE_SQL_DROP =
"drop table RedirectNotFoundEntry";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create unique index IX_84671762 on RedirectNotFoundEntry (groupId, url[$COLUMN_LENGTH:4000$])"
	};

}