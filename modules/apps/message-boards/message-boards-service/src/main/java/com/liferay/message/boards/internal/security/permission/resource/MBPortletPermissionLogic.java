/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.security.permission.resource;

import com.liferay.message.boards.service.MBBanLocalService;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;

/**
 * @author Sergio González
 */
public class MBPortletPermissionLogic
	implements PortletResourcePermissionLogic {

	public MBPortletPermissionLogic(MBBanLocalService mbBanLocalService) {
		_mbBanLocalService = mbBanLocalService;
	}

	@Override
	public Boolean contains(
		PermissionChecker permissionChecker, String name, Group group,
		String actionId) {

		if (_mbBanLocalService.hasBan(
				group.getGroupId(), permissionChecker.getUserId())) {

			return false;
		}

		return null;
	}

	private final MBBanLocalService _mbBanLocalService;

}