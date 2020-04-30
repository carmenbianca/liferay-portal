/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Account;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Brian Wing Shun Chan
 */
public interface AccountPermission {

	public void check(
			PermissionChecker permissionChecker, Account account,
			String actionId)
		throws PortalException;

	public void check(
			PermissionChecker permissionChecker, long accountId,
			String actionId)
		throws PortalException;

	public boolean contains(
			PermissionChecker permissionChecker, Account account,
			String actionId)
		throws PortalException;

	public boolean contains(
			PermissionChecker permissionChecker, long accountId,
			String actionId)
		throws PortalException;

}