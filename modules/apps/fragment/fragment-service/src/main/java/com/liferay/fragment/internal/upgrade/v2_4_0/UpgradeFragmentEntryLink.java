/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.internal.upgrade.v2_4_0;

import com.liferay.fragment.internal.upgrade.v2_4_0.util.FragmentEntryLinkTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Eudaldo Alonso
 */
public class UpgradeFragmentEntryLink extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("FragmentEntryLink", "segmentsExperienceId")) {
			alter(
				FragmentEntryLinkTable.class,
				new AlterTableAddColumn("segmentsExperienceId", "LONG"));
		}
	}

}