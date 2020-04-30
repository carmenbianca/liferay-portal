/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.upgrade.v2_3_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradeCompanyId;

/**
 * @author Alberto Chaparro
 */
public class UpgradeCompanyId extends BaseUpgradeCompanyId {

	@Override
	protected TableUpdater[] getTableUpdaters() {
		return new TableUpdater[] {
			new TableUpdater("CTMessage", "CTCollection", "ctCollectionId")
		};
	}

}