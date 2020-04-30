/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.internal.upgrade.v2_1_0;

import com.liferay.data.engine.internal.upgrade.v2_1_0.util.DEDataDefinitionFieldLinkTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Pavel Savinov
 */
public class UpgradeDEDataDefinitionFieldLink extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("DEDataDefinitionFieldLink", "createDate")) {
			alter(
				DEDataDefinitionFieldLinkTable.class,
				new AlterTableAddColumn("createDate", "DATE null"));
		}

		if (!hasColumn("DEDataDefinitionFieldLink", "modifiedDate")) {
			alter(
				DEDataDefinitionFieldLinkTable.class,
				new AlterTableAddColumn("modifiedDate", "DATE null"));
		}

		if (!hasColumn("DEDataDefinitionFieldLink", "lastPublishDate")) {
			alter(
				DEDataDefinitionFieldLinkTable.class,
				new AlterTableAddColumn("lastPublishDate", "DATE null"));
		}
	}

}