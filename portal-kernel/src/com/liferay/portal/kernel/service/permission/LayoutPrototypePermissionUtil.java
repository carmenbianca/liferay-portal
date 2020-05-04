/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Jorge Ferrer
 */
public class LayoutPrototypePermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long layoutPrototypeId,
			String actionId)
		throws PrincipalException {

		getLayoutPrototypePermission().check(
			permissionChecker, layoutPrototypeId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long layoutPrototypeId,
		String actionId) {

		return getLayoutPrototypePermission().contains(
			permissionChecker, layoutPrototypeId, actionId);
	}

	public static LayoutPrototypePermission getLayoutPrototypePermission() {
		return _layoutPrototypePermission;
	}

	public void setLayoutPrototypePermission(
		LayoutPrototypePermission layoutPrototypePermission) {

		_layoutPrototypePermission = layoutPrototypePermission;
	}

	private static LayoutPrototypePermission _layoutPrototypePermission;

}