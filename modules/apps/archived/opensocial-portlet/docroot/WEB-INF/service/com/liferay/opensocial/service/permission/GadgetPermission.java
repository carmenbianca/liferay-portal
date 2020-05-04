/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.service.permission;

import com.liferay.opensocial.model.Gadget;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Michael Young
 */
public class GadgetPermission {

	public static final String RESOURCE_NAME = "com.liferay.opensocial";

	public static void check(
			PermissionChecker permissionChecker, long groupId, long gadgetId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, gadgetId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, long gadgetId,
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, Gadget.class.getName(), gadgetId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		return permissionChecker.hasPermission(
			groupId, RESOURCE_NAME, groupId, actionId);
	}

}