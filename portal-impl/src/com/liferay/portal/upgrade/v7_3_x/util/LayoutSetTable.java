/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_3_x.util;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class LayoutSetTable {

	public static final String TABLE_NAME = "LayoutSet";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"layoutSetId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"privateLayout", Types.BOOLEAN}, {"logoId", Types.BIGINT},
		{"themeId", Types.VARCHAR}, {"colorSchemeId", Types.VARCHAR},
		{"css", Types.CLOB}, {"settings_", Types.CLOB},
		{"layoutSetPrototypeUuid", Types.VARCHAR},
		{"layoutSetPrototypeLinkEnabled", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
new HashMap<String, Integer>();

static {
TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);

TABLE_COLUMNS_MAP.put("layoutSetId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("privateLayout", Types.BOOLEAN);

TABLE_COLUMNS_MAP.put("logoId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("themeId", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("colorSchemeId", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("css", Types.CLOB);

TABLE_COLUMNS_MAP.put("settings_", Types.CLOB);

TABLE_COLUMNS_MAP.put("layoutSetPrototypeUuid", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("layoutSetPrototypeLinkEnabled", Types.BOOLEAN);

}
	public static final String TABLE_SQL_CREATE =
"create table LayoutSet (mvccVersion LONG default 0 not null,layoutSetId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,privateLayout BOOLEAN,logoId LONG,themeId VARCHAR(75) null,colorSchemeId VARCHAR(75) null,css TEXT null,settings_ TEXT null,layoutSetPrototypeUuid VARCHAR(75) null,layoutSetPrototypeLinkEnabled BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table LayoutSet";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_BC1F2123 on LayoutSet (companyId, layoutSetPrototypeUuid[$COLUMN_LENGTH:75$])",
		"create unique index IX_48550691 on LayoutSet (groupId, privateLayout)",
		"create index IX_72BBA8B7 on LayoutSet (layoutSetPrototypeUuid[$COLUMN_LENGTH:75$])",
		"create index IX_1B698D9 on LayoutSet (privateLayout, logoId)"
	};

}