/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.upgrade.v1_2_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Peter Shin
 */
public class UpgradeKBStructure extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasTable("KBStructure")) {
			runSQL("drop table KBStructure");
		}
	}

}