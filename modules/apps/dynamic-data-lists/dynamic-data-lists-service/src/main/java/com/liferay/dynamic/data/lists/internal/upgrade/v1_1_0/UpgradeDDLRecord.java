/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.internal.upgrade.v1_1_0;

import com.liferay.dynamic.data.lists.model.DDLRecordSetConstants;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Pedro Queiroz
 */
public class UpgradeDDLRecord extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL(
			"update DDLRecord set recordSetVersion = '" +
				DDLRecordSetConstants.VERSION_DEFAULT + "'");
	}

}