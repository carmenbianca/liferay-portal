/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.db;

import com.liferay.portal.kernel.dao.db.BaseDBFactory;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBType;

/**
 * @author Shuyang Zhou
 */
public class HypersonicDBFactory extends BaseDBFactory {

	@Override
	public DB doCreate(int dbMajorVersion, int dbMinorVersion) {
		return new HypersonicDB(dbMajorVersion, dbMinorVersion);
	}

	@Override
	public DBType getDBType() {
		return DBType.HYPERSONIC;
	}

}