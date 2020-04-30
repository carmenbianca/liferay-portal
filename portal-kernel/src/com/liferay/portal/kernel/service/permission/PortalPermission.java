/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Charles May
 */
public interface PortalPermission {

	public void check(PermissionChecker permissionChecker, String actionId)
		throws PrincipalException;

	public boolean contains(
		PermissionChecker permissionChecker, String actionId);

}