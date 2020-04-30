/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.util;

import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.kernel.upgrade.util.UpgradeTableFactory;

/**
 * @author Brian Wing Shun Chan
 */
public class DefaultUpgradeTableFactoryImpl implements UpgradeTableFactory {

	@Override
	public UpgradeTable getUpgradeTable(
		String tableName, Object[][] columns, UpgradeColumn... upgradeColumns) {

		return new DefaultUpgradeTableImpl(tableName, columns, upgradeColumns);
	}

}