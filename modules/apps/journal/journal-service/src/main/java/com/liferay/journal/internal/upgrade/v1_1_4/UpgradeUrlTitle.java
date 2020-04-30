/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.upgrade.v1_1_4;

import com.liferay.journal.internal.upgrade.v1_1_4.util.JournalArticleTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Jürgen Kappler
 */
public class UpgradeUrlTitle extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			JournalArticleTable.class,
			new AlterColumnType("urlTitle", "VARCHAR(255) null"));
	}

}