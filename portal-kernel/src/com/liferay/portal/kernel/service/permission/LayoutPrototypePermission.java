/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Jorge Ferrer
 */
public interface LayoutPrototypePermission {

	public void check(
			PermissionChecker permissionChecker, long layoutPrototypeId,
			String actionId)
		throws PrincipalException;

	public boolean contains(
		PermissionChecker permissionChecker, long layoutPrototypeId,
		String actionId);

}