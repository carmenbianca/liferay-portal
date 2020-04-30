/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.internal.upgrade.v1_0_3;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Shinn Lok
 */
public class UpgradeSchema extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		String template = StringUtil.read(
			UpgradeSchema.class.getResourceAsStream("dependencies/update.sql"));

		runSQLTemplateString(template, false);
	}

}