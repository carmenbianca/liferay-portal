/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.internal.upgrade.v1_0_4;

import com.liferay.polls.constants.PollsPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Rafael Praxedes
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"25_WAR_pollsweb", PollsPortletKeys.POLLS},
			{"59_WAR_pollsweb", PollsPortletKeys.POLLS_DISPLAY}
		};
	}

}