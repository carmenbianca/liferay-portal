/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.upgrade.v1_0_0;

import com.liferay.dynamic.data.mapping.constants.DDMPortletKeys;

/**
 * @author Rafael Praxedes
 */
public class UpgradeLastPublishDate
	extends com.liferay.portal.upgrade.v7_0_0.UpgradeLastPublishDate {

	@Override
	protected void doUpgrade() throws Exception {
		addLastPublishDateColumn("DDMStructure");

		updateLastPublishDates(
			DDMPortletKeys.DYNAMIC_DATA_MAPPING, "DDMStructure");

		addLastPublishDateColumn("DDMTemplate");

		updateLastPublishDates(
			DDMPortletKeys.DYNAMIC_DATA_MAPPING, "DDMTemplate");
	}

}