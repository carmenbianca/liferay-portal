/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_6;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_6.util.RepositoryTable;

/**
 * @author Alec Shay
 */
public class UpgradeRepository extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			RepositoryTable.class,
			new AlterColumnType("name", "VARCHAR(200) null"));
	}

}