/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutSetBranch;
import com.liferay.portal.kernel.model.RecentLayoutSetBranch;
import com.liferay.portal.service.base.RecentLayoutSetBranchLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 * @author Preston Crary
 */
public class RecentLayoutSetBranchLocalServiceImpl
	extends RecentLayoutSetBranchLocalServiceBaseImpl {

	@Override
	public RecentLayoutSetBranch addRecentLayoutSetBranch(
			long userId, long layoutSetBranchId, long layoutSetId)
		throws PortalException {

		LayoutSetBranch layoutSetBranch =
			layoutSetBranchPersistence.findByPrimaryKey(layoutSetBranchId);

		RecentLayoutSetBranch recentLayoutSetBranch =
			recentLayoutSetBranchPersistence.create(
				counterLocalService.increment());

		recentLayoutSetBranch.setGroupId(layoutSetBranch.getGroupId());
		recentLayoutSetBranch.setCompanyId(layoutSetBranch.getCompanyId());
		recentLayoutSetBranch.setUserId(userId);
		recentLayoutSetBranch.setLayoutSetBranchId(layoutSetBranchId);
		recentLayoutSetBranch.setLayoutSetId(layoutSetId);

		return recentLayoutSetBranchPersistence.update(recentLayoutSetBranch);
	}

	@Override
	public void deleteRecentLayoutSetBranches(long layoutSetBranchId) {
		recentLayoutSetBranchPersistence.removeByLayoutSetBranchId(
			layoutSetBranchId);
	}

	@Override
	public void deleteUserRecentLayoutSetBranches(long userId) {
		recentLayoutSetBranchPersistence.removeByUserId(userId);
	}

	@Override
	public RecentLayoutSetBranch fetchRecentLayoutSetBranch(
		long userId, long layoutSetId) {

		return recentLayoutSetBranchPersistence.fetchByU_L(userId, layoutSetId);
	}

}