/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.upgrade.v1_3_4;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Roberto Díaz
 */
public class UpgradeKBArticle extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL("alter table KBArticle add sourceURL STRING null");
	}

}