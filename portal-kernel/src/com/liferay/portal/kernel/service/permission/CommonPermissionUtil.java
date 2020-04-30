/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Brian Wing Shun Chan
 */
public class CommonPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long classNameId, long classPK,
			String actionId)
		throws PortalException {

		getCommonPermission().check(
			permissionChecker, classNameId, classPK, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, String className, long classPK,
			String actionId)
		throws PortalException {

		getCommonPermission().check(
			permissionChecker, className, classPK, actionId);
	}

	public static CommonPermission getCommonPermission() {
		return _commonPermission;
	}

	public void setCommonPermission(CommonPermission commonPermission) {
		_commonPermission = commonPermission;
	}

	private static CommonPermission _commonPermission;

}