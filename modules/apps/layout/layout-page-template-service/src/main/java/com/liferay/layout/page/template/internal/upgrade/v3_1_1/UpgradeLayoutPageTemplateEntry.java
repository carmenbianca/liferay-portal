/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.internal.upgrade.v3_1_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Pavel Savinov
 */
public class UpgradeLayoutPageTemplateEntry extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		upgradeIndex();
	}

	protected void upgradeIndex() throws Exception {
		runSQL("drop index IX_A075DAA4 on LayoutPageTemplateEntry");

		runSQL(
			"create unique index IX_C3960EB1 on LayoutPageTemplateEntry (" +
				"groupId, name, type_)");
	}

}