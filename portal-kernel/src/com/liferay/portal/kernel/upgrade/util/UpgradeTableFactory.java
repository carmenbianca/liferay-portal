/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

/**
 * @author Brian Wing Shun Chan
 */
public interface UpgradeTableFactory {

	public UpgradeTable getUpgradeTable(
		String tableName, Object[][] columns, UpgradeColumn... upgradeColumns);

}