/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.file.rank.internal.model.listener;

import com.liferay.document.library.file.rank.service.DLFileRankLocalService;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(service = ModelListener.class)
public class UserModelListener extends BaseModelListener<User> {

	@Override
	public void onBeforeRemove(User user) {
		_dlFileRankLocalService.deleteFileRanksByUserId(user.getUserId());
	}

	@Reference
	private DLFileRankLocalService _dlFileRankLocalService;

}