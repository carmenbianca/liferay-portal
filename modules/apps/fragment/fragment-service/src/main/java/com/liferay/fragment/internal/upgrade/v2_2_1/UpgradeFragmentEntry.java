/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.internal.upgrade.v2_2_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Alberto Chaparro
 */
public class UpgradeFragmentEntry extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL("drop index IX_62913C70 on FragmentEntry");
	}

}