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
public class PasswordPolicyPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long passwordPolicyId,
			String actionId)
		throws PrincipalException {

		getPasswordPolicyPermission().check(
			permissionChecker, passwordPolicyId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long passwordPolicyId,
		String actionId) {

		return getPasswordPolicyPermission().contains(
			permissionChecker, passwordPolicyId, actionId);
	}

	public static PasswordPolicyPermission getPasswordPolicyPermission() {
		return _passwordPolicyPermission;
	}

	public void setPasswordPolicyPermission(
		PasswordPolicyPermission passwordPolicyPermission) {

		_passwordPolicyPermission = passwordPolicyPermission;
	}

	private static PasswordPolicyPermission _passwordPolicyPermission;

}