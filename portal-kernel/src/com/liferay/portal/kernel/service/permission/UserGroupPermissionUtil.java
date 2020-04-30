/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Brian Wing Shun Chan
 */
public class UserGroupPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long userGroupId,
			String actionId)
		throws PrincipalException {

		getUserGroupPermission().check(
			permissionChecker, userGroupId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long userGroupId,
		String actionId) {

		return getUserGroupPermission().contains(
			permissionChecker, userGroupId, actionId);
	}

	public static UserGroupPermission getUserGroupPermission() {
		return _userGroupPermission;
	}

	public void setUserGroupPermission(
		UserGroupPermission userGroupPermission) {

		_userGroupPermission = userGroupPermission;
	}

	private static UserGroupPermission _userGroupPermission;

}