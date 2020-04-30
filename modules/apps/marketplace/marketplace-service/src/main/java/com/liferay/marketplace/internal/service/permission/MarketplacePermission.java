/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.internal.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Ryan Park
 */
public class MarketplacePermission {

	public static void check(PermissionChecker permissionChecker)
		throws PortalException {

		if (!contains(permissionChecker)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker)
		throws PortalException {

		if (!permissionChecker.isOmniadmin()) {
			return false;
		}

		return true;
	}

}