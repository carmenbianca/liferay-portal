/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.permission;

import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.model.impl.UserGroupRoleModelImpl;

/**
 * @author Preston Crary
 */
public class UserGroupRoleModelListener
	extends BaseModelListener<UserGroupRole> {

	@Override
	public void onAfterCreate(UserGroupRole userGroupRole) {
		_clearCache(userGroupRole);
	}

	@Override
	public void onAfterRemove(UserGroupRole userGroupRole) {
		_clearCache(userGroupRole);
	}

	@Override
	public void onAfterUpdate(UserGroupRole userGroupRole) {
		_clearCache(userGroupRole);
	}

	@Override
	public void onBeforeUpdate(UserGroupRole userGroupRole) {
		UserGroupRoleModelImpl userGroupRoleModelImpl =
			(UserGroupRoleModelImpl)userGroupRole;

		long originalUserId = userGroupRoleModelImpl.getOriginalUserId();

		if (originalUserId != userGroupRoleModelImpl.getUserId()) {
			PermissionCacheUtil.clearCache(originalUserId);
		}
	}

	private void _clearCache(UserGroupRole userGroupRole) {
		if (userGroupRole != null) {
			PermissionCacheUtil.clearCache(userGroupRole.getUserId());
		}
	}

}