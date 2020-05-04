/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.service.permission;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Michael C. Han
 */
public class ExpandoColumnPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, ExpandoColumn column,
			String actionId)
		throws PortalException {

		getExpandoColumnPermission().check(permissionChecker, column, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long columnId, String actionId)
		throws PortalException {

		getExpandoColumnPermission().check(
			permissionChecker, columnId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long companyId,
			String className, String tableName, String columnName,
			String actionId)
		throws PortalException {

		getExpandoColumnPermission().check(
			permissionChecker, companyId, className, tableName, columnName,
			actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, ExpandoColumn column,
		String actionId) {

		return getExpandoColumnPermission().contains(
			permissionChecker, column, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long columnId, String actionId)
		throws PortalException {

		return getExpandoColumnPermission().contains(
			permissionChecker, columnId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long companyId, String className,
		String tableName, String columnName, String actionId) {

		return getExpandoColumnPermission().contains(
			permissionChecker, companyId, className, tableName, columnName,
			actionId);
	}

	public static ExpandoColumnPermission getExpandoColumnPermission() {
		return _expandoColumnPermission;
	}

	public void setExpandoColumnPermission(
		ExpandoColumnPermission expandoColumnPermission) {

		_expandoColumnPermission = expandoColumnPermission;
	}

	private static ExpandoColumnPermission _expandoColumnPermission;

}