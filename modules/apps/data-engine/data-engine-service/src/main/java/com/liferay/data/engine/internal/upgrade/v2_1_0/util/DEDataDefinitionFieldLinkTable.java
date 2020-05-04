/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.internal.upgrade.v2_1_0.util;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author	  Pavel Savinov
 * @generated
 */
public class DEDataDefinitionFieldLinkTable {

	public static final String TABLE_NAME = "DEDataDefinitionFieldLink";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"deDataDefinitionFieldLinkId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"classNameId", Types.BIGINT}, {"classPK", Types.BIGINT},
		{"ddmStructureId", Types.BIGINT}, {"fieldName", Types.VARCHAR},
		{"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
new HashMap<String, Integer>();

static {
TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("deDataDefinitionFieldLinkId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);

TABLE_COLUMNS_MAP.put("ddmStructureId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("fieldName", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);

}
	public static final String TABLE_SQL_CREATE =
"create table DEDataDefinitionFieldLink (uuid_ VARCHAR(75) null,deDataDefinitionFieldLinkId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,ddmStructureId LONG,fieldName VARCHAR(75) null,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP =
"drop table DEDataDefinitionFieldLink";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create unique index IX_2CEE588F on DEDataDefinitionFieldLink (classNameId, classPK, ddmStructureId, fieldName[$COLUMN_LENGTH:75$])",
		"create index IX_7BAE5B6E on DEDataDefinitionFieldLink (classNameId, ddmStructureId, fieldName[$COLUMN_LENGTH:75$])",
		"create index IX_9442C171 on DEDataDefinitionFieldLink (ddmStructureId)",
		"create index IX_5145BB70 on DEDataDefinitionFieldLink (uuid_[$COLUMN_LENGTH:75$], companyId)",
		"create unique index IX_AAE65DF2 on DEDataDefinitionFieldLink (uuid_[$COLUMN_LENGTH:75$], groupId)"
	};

}