/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.test.model.impl;

import java.sql.Types;

/**
 * @author Preston Crary
 */
public class BuildAutoUpgradeTestEntityModelImpl {

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"data_", Types.VARCHAR}
	};

	public static final String TABLE_NAME = "BuildAutoUpgradeTestEntity";

	public static final String TABLE_SQL_CREATE =
		"create table BuildAutoUpgradeTestEntity (id_ LONG not null primary " +
			"key, data_ VARCHAR(75) null);";

}