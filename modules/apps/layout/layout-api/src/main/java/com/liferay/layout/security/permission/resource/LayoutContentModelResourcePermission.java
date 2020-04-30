/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.security.permission.resource;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Rubén Pulido
 */
public interface LayoutContentModelResourcePermission {

	public boolean contains(
		PermissionChecker permissionChecker, long plid, String actionId);

	public boolean contains(
		PermissionChecker permissionChecker, String className, long classPK,
		String actionId);

}