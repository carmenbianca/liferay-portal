/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.internal.upgrade.v1_1_1;

import com.liferay.blogs.internal.upgrade.v1_1_1.util.BlogsEntryTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Jürgen Kappler
 */
public class UpgradeUrlTitle extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			BlogsEntryTable.class,
			new AlterColumnType("urlTitle", "VARCHAR(255) null"));
	}

}