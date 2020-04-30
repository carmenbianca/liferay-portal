/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.microblogs.web.internal.upgrade.v1_0_0;

import com.liferay.microblogs.constants.MicroblogsPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Adolfo Pérez
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"1_WAR_microblogsportlet", MicroblogsPortletKeys.MICROBLOGS},
			{
				"2_WAR_microblogsportlet",
				MicroblogsPortletKeys.MICROBLOGS_STATUS_UPDATE
			}
		};
	}

}