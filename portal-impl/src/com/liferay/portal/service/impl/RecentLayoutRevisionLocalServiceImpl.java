/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutRevision;
import com.liferay.portal.kernel.model.RecentLayoutRevision;
import com.liferay.portal.service.base.RecentLayoutRevisionLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 * @author Preston Crary
 */
public class RecentLayoutRevisionLocalServiceImpl
	extends RecentLayoutRevisionLocalServiceBaseImpl {

	@Override
	public RecentLayoutRevision addRecentLayoutRevision(
			long userId, long layoutRevisionId, long layoutSetBranchId,
			long plid)
		throws PortalException {

		LayoutRevision layoutRevision =
			layoutRevisionPersistence.findByPrimaryKey(layoutRevisionId);

		RecentLayoutRevision recentLayoutRevision =
			recentLayoutRevisionPersistence.create(
				counterLocalService.increment());

		recentLayoutRevision.setGroupId(layoutRevision.getGroupId());
		recentLayoutRevision.setCompanyId(layoutRevision.getCompanyId());
		recentLayoutRevision.setUserId(userId);
		recentLayoutRevision.setLayoutRevisionId(layoutRevisionId);
		recentLayoutRevision.setLayoutSetBranchId(layoutSetBranchId);
		recentLayoutRevision.setPlid(plid);

		return recentLayoutRevisionPersistence.update(recentLayoutRevision);
	}

	@Override
	public void deleteRecentLayoutRevisions(long layoutRevisionId) {
		recentLayoutRevisionPersistence.removeByLayoutRevisionId(
			layoutRevisionId);
	}

	@Override
	public void deleteUserRecentLayoutRevisions(long userId) {
		recentLayoutRevisionPersistence.removeByUserId(userId);
	}

	@Override
	public RecentLayoutRevision fetchRecentLayoutRevision(
		long userId, long layoutSetBranchId, long plid) {

		return recentLayoutRevisionPersistence.fetchByU_L_P(
			userId, layoutSetBranchId, plid);
	}

}