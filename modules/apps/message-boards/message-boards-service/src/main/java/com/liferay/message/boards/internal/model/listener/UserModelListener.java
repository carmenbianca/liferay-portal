/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.model.listener;

import com.liferay.message.boards.service.MBBanLocalService;
import com.liferay.message.boards.service.MBStatsUserLocalService;
import com.liferay.message.boards.service.MBThreadFlagLocalService;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(immediate = true, service = ModelListener.class)
public class UserModelListener extends BaseModelListener<User> {

	@Override
	public void onBeforeRemove(User user) {
		_mbBanLocalService.deleteBansByBanUserId(user.getUserId());
		_mbStatsUserLocalService.deleteStatsUsersByUserId(user.getUserId());
		_mbThreadFlagLocalService.deleteThreadFlagsByUserId(user.getUserId());
	}

	@Reference
	private MBBanLocalService _mbBanLocalService;

	@Reference
	private MBStatsUserLocalService _mbStatsUserLocalService;

	@Reference
	private MBThreadFlagLocalService _mbThreadFlagLocalService;

}