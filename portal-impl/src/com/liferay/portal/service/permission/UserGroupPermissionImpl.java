/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.UserGroupPermission;

/**
 * @author Charles May
 */
public class UserGroupPermissionImpl implements UserGroupPermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, long userGroupId,
			String actionId)
		throws PrincipalException {

		if (!contains(permissionChecker, userGroupId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, UserGroup.class.getName(), userGroupId,
				actionId);
		}
	}

	@Override
	public boolean contains(
		PermissionChecker permissionChecker, long userGroupId,
		String actionId) {

		return permissionChecker.hasPermission(
			null, UserGroup.class.getName(), userGroupId, actionId);
	}

}