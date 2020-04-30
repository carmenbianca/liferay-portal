/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.internal.upgrade.v2_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.redirect.internal.upgrade.v2_0_0.util.RedirectNotFoundEntryTable;

/**
 * @author Alejandro Tardín
 */
public class UpgradeRedirectNotFoundEntry extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			RedirectNotFoundEntryTable.class, new AlterTableAddColumn("userId"),
			new AlterTableAddColumn("userName"),
			new AlterTableAddColumn("ignored"));
	}

}