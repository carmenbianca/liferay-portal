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
public class UserPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long userId,
			long[] organizationIds, String actionId)
		throws PrincipalException {

		getUserPermission().check(
			permissionChecker, userId, organizationIds, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long userId, String actionId)
		throws PrincipalException {

		getUserPermission().check(permissionChecker, userId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long userId,
		long[] organizationIds, String actionId) {

		return getUserPermission().contains(
			permissionChecker, userId, organizationIds, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long userId, String actionId) {

		return getUserPermission().contains(
			permissionChecker, userId, actionId);
	}

	public static UserPermission getUserPermission() {
		return _userPermission;
	}

	public void setUserPermission(UserPermission userPermission) {
		_userPermission = userPermission;
	}

	private static UserPermission _userPermission;

}