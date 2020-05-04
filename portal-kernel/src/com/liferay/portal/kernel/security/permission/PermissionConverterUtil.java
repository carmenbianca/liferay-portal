/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Permission;
import com.liferay.portal.kernel.model.Role;

import java.util.List;

/**
 * @author Michael C. Han
 */
public class PermissionConverterUtil {

	public static List<Permission> convertPermissions(long roleId)
		throws PortalException {

		return getPermissionConverter().convertPermissions(roleId);
	}

	public static List<Permission> convertPermissions(
			long roleId, PermissionConversionFilter permissionConversionFilter)
		throws PortalException {

		return getPermissionConverter().convertPermissions(
			roleId, permissionConversionFilter);
	}

	public static List<Permission> convertPermissions(Role role)
		throws PortalException {

		return getPermissionConverter().convertPermissions(role);
	}

	public static List<Permission> convertPermissions(
			Role role, PermissionConversionFilter permissionConversionFilter)
		throws PortalException {

		return getPermissionConverter().convertPermissions(
			role, permissionConversionFilter);
	}

	public static PermissionConverter getPermissionConverter() {
		return _permissionConverter;
	}

	public void setPermissionConverter(
		PermissionConverter permissionConverter) {

		_permissionConverter = permissionConverter;
	}

	private static PermissionConverter _permissionConverter;

}