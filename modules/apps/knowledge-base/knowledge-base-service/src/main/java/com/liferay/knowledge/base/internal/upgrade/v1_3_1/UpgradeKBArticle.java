/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.upgrade.v1_3_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Roberto Díaz
 */
public class UpgradeKBArticle extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		String template = StringUtil.read(
			UpgradeKBArticle.class.getResourceAsStream(
				"dependencies/update.sql"));

		runSQLTemplateString(template, false);
	}

}