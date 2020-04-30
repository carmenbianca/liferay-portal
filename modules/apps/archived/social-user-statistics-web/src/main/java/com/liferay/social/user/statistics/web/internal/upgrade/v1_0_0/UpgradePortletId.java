/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.user.statistics.web.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;
import com.liferay.social.user.statistics.constants.SocialUserStatisticsPortletKeys;

/**
 * @author Iván Zaera
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"180", SocialUserStatisticsPortletKeys.SOCIAL_USER_STATISTICS}
		};
	}

}