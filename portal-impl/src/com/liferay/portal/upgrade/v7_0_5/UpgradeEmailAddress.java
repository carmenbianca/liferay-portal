/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_5;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_5.util.EmailAddressTable;

/**
 * @author Ugurcan Cetin
 */
public class UpgradeEmailAddress extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			EmailAddressTable.class,
			new AlterColumnType("address", "VARCHAR(254) null"));
	}

}