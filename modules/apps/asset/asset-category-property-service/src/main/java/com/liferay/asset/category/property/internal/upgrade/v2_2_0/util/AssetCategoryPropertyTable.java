/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.category.property.internal.upgrade.v2_2_0.util;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class AssetCategoryPropertyTable {

	public static final String TABLE_NAME = "AssetCategoryProperty";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"categoryPropertyId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"categoryId", Types.BIGINT},
		{"key_", Types.VARCHAR}, {"value", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
new HashMap<String, Integer>();

static {
TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);

TABLE_COLUMNS_MAP.put("categoryPropertyId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("categoryId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("value", Types.VARCHAR);

}
	public static final String TABLE_SQL_CREATE =
"create table AssetCategoryProperty (mvccVersion LONG default 0 not null,categoryPropertyId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,key_ VARCHAR(255) null,value VARCHAR(255) null)";

	public static final String TABLE_SQL_DROP =
"drop table AssetCategoryProperty";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create unique index IX_DBD111AA on AssetCategoryProperty (categoryId, key_[$COLUMN_LENGTH:255$])",
		"create index IX_52340033 on AssetCategoryProperty (companyId, key_[$COLUMN_LENGTH:255$])"
	};

}