/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.RolePermission;

/**
 * @author Charles May
 */
public class RolePermissionImpl implements RolePermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, long roleId, String actionId)
		throws PrincipalException {

		if (!contains(permissionChecker, roleId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Role.class.getName(), roleId, actionId);
		}
	}

	@Override
	public boolean contains(
		PermissionChecker permissionChecker, long groupId, long roleId,
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, Role.class.getName(), roleId, actionId);
	}

	@Override
	public boolean contains(
		PermissionChecker permissionChecker, long roleId, String actionId) {

		return contains(permissionChecker, 0, roleId, actionId);
	}

}