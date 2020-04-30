/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.internal.dto.v1_0.util;

import com.liferay.headless.delivery.dto.v1_0.CreatorStatistics;
import com.liferay.message.boards.service.MBStatsUserLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

/**
 * @author Luis Miguel Barcos
 */
public class CreatorStatisticsUtil {

	public static CreatorStatistics toCreatorStatistics(
			MBStatsUserLocalService mbStatsUserLocalService, String languageId,
			User user)
		throws PortalException {

		String[] ranks = mbStatsUserLocalService.getUserRank(
			user.getGroupId(), languageId, user.getUserId());

		return new CreatorStatistics() {
			{
				joinDate = user.getCreateDate();
				lastPostDate = mbStatsUserLocalService.getLastPostDateByUserId(
					user.getGroupId(), user.getUserId());
				postsNumber = Math.toIntExact(
					mbStatsUserLocalService.getMessageCountByUserId(
						user.getUserId()));
				rank = ranks[1].equals(StringPool.BLANK) ? ranks[0] : ranks[1];
			}
		};
	}

}