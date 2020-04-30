/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.internal.upgrade.v2_3_0;

import com.liferay.fragment.internal.upgrade.v2_3_0.util.FragmentEntryTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Jürgen Kappler
 */
public class UpgradeFragmentEntry extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("FragmentEntry", "cacheable")) {
			alter(
				FragmentEntryTable.class,
				new AlterTableAddColumn("cacheable", "BOOLEAN"));
		}
	}

}