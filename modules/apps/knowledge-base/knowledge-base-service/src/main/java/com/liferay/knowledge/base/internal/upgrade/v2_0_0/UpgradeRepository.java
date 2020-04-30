/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.upgrade.v2_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradeRepository;

/**
 * @author Adolfo Pérez
 */
public class UpgradeRepository extends BaseUpgradeRepository {

	@Override
	protected String[][] getRenamePortletNamesArray() {
		return new String[][] {
			{
				"com.liferay.knowledgebase.admin.portlet.AdminPortlet",
				"com.liferay.knowledge.base"
			},
			{"3_WAR_knowledgebaseportlet", "com.liferay.knowledge.base"}
		};
	}

}