/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.internal.upgrade.v2_1_3;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Jürgen Kappler
 */
public class UpgradeSchema extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("FragmentEntryLink", "configuration")) {
			runSQL("alter table FragmentEntryLink add configuration TEXT");
		}
	}

}