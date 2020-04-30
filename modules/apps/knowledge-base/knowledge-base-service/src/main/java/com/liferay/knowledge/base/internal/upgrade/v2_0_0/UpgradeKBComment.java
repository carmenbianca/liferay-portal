/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.upgrade.v2_0_0;

import com.liferay.knowledge.base.constants.KBCommentConstants;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Adolfo Pérez
 */
public class UpgradeKBComment extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("KBComment", "status")) {
			runSQL("alter table KBComment add status INT null");
		}

		runSQL(
			"update KBComment set status = " +
				KBCommentConstants.STATUS_COMPLETED + " where status is NULL");
	}

}