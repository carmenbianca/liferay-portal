/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.internal.upgrade.v1_0_0;

import com.liferay.polls.constants.PollsPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Miguel Pastor
 * @author Peter Fellwock
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"25", PollsPortletKeys.POLLS},
			{"59", PollsPortletKeys.POLLS_DISPLAY}
		};
	}

}