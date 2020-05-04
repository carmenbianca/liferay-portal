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
public class PortalPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, String actionId)
		throws PrincipalException {

		getPortalPermission().check(permissionChecker, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, String actionId) {

		return getPortalPermission().contains(permissionChecker, actionId);
	}

	public static PortalPermission getPortalPermission() {
		return _portalPermission;
	}

	public void setPortalPermission(PortalPermission portalPermission) {
		_portalPermission = portalPermission;
	}

	private static PortalPermission _portalPermission;

}