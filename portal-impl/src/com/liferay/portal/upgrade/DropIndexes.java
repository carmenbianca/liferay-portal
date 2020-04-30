/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade;

import com.liferay.portal.events.StartupHelperUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Brian Wing Shun Chan
 */
public class DropIndexes extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		StartupHelperUtil.setDropIndexes(true);
	}

}