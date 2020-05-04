/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.opener.internal.upgrade.v1_1_0;

import com.liferay.document.library.opener.internal.upgrade.v1_1_0.util.DLOpenerFileEntryReferenceTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Cristina González
 */
public class UpgradeDLOpenerFileEntryReference extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			DLOpenerFileEntryReferenceTable.class,
			new AlterTableAddColumn("referenceType", "VARCHAR(75) null"));

		runSQL(
			"update " + DLOpenerFileEntryReferenceTable.TABLE_NAME +
				" set referenceType = 'GoogleDrive'");
	}

}