/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_2_x;

import com.liferay.portal.kernel.upgrade.BaseUpgradeBadColumnNames;
import com.liferay.portal.upgrade.v7_2_x.util.CompanyTable;
import com.liferay.portal.upgrade.v7_2_x.util.LayoutTable;

/**
 * @author Tina Tian
 */
public class UpgradeBadColumnNames extends BaseUpgradeBadColumnNames {

	@Override
	protected void doUpgrade() throws Exception {
		upgradeBadColumnNames(CompanyTable.class, "system");
		upgradeBadColumnNames(LayoutTable.class, "system");
	}

}