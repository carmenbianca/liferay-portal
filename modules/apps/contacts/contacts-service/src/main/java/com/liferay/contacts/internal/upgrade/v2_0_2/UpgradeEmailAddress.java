/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.internal.upgrade.v2_0_2;

import com.liferay.contacts.internal.upgrade.v2_0_2.util.EntryTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Tibor Lipusz
 */
public class UpgradeEmailAddress extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			EntryTable.class,
			new AlterColumnType("emailAddress", "VARCHAR(254) null"));
	}

}