/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.group.statistics.web.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;
import com.liferay.social.group.statistics.web.internal.constants.SocialGroupStatisticsPortletKeys;

/**
 * @author Iván Zaera
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"181", SocialGroupStatisticsPortletKeys.SOCIAL_GROUP_STATISTICS}
		};
	}

}