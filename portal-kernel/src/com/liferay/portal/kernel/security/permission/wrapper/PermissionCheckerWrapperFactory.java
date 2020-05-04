/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission.wrapper;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Preston Crary
 */
public interface PermissionCheckerWrapperFactory {

	public PermissionChecker wrapPermissionChecker(
		PermissionChecker permissionChecker);

}