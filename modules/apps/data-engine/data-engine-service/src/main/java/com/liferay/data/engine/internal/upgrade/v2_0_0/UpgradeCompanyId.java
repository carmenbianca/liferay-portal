/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.internal.upgrade.v2_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradeCompanyId;

/**
 * @author Alberto Chaparro
 */
public class UpgradeCompanyId extends BaseUpgradeCompanyId {

	@Override
	protected TableUpdater[] getTableUpdaters() {
		return new TableUpdater[] {
			new TableUpdater("DEDataDefinitionFieldLink", "Group_", "groupId")
		};
	}

}