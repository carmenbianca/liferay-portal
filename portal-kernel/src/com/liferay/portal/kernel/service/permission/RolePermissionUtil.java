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
public class RolePermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long roleId, String actionId)
		throws PrincipalException {

		getRolePermission().check(permissionChecker, roleId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, long roleId,
		String actionId) {

		return getRolePermission().contains(
			permissionChecker, groupId, roleId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long roleId, String actionId) {

		return getRolePermission().contains(
			permissionChecker, roleId, actionId);
	}

	public static RolePermission getRolePermission() {
		return _rolePermission;
	}

	public void setRolePermission(RolePermission rolePermission) {
		_rolePermission = rolePermission;
	}

	private static RolePermission _rolePermission;

}