/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_1_x;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_1_x.util.DLFileEntryTypeTable;

/**
 * @author José María Muñoz
 */
public class UpgradeDocumentLibrary extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumnType(
				"DLFileEntryType", "fileEntryTypeKey", "VARCHAR(75) null")) {

			alter(
				DLFileEntryTypeTable.class,
				new AlterColumnType("fileEntryTypeKey", "VARCHAR(75) null"));
		}
	}

}