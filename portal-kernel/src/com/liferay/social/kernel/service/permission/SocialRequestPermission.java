/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Zsolt Berentey
 */
public interface SocialRequestPermission {

	public void check(
			PermissionChecker permissionChecker, long requestId,
			String actionId)
		throws PortalException;

	public boolean contains(
			PermissionChecker permissionChecker, long requestId,
			String actionId)
		throws PortalException;

}