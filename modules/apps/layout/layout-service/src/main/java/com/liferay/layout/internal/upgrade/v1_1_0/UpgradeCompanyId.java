/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.upgrade.v1_1_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradeCompanyId;

/**
 * @author Pavel Savinov
 */
public class UpgradeCompanyId extends BaseUpgradeCompanyId {

	@Override
	protected TableUpdater[] getTableUpdaters() {
		return new TableUpdater[] {
			new TableUpdater("LayoutClassedModelUsage", "Layout", "plid")
		};
	}

}