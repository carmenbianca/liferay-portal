/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.upgrade.v3_1_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Jeyvison Nascimento
 */
public class UpgradeDDMStructureLayout extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("DDMStructureLayout", "description") &&
			!hasColumn("DDMStructureLayout", "name")) {

			runSQL("drop index IX_B7158C0A on DDMStructureLayout");

			String template = StringUtil.read(
				UpgradeDDMStructureLayout.class.getResourceAsStream(
					"dependencies/update.sql"));

			runSQLTemplateString(template, true);
		}
	}

}