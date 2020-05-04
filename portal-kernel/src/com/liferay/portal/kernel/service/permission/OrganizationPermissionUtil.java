/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long organizationId,
			String actionId)
		throws PortalException {

		getOrganizationPermission().check(
			permissionChecker, organizationId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, Organization organization,
			String actionId)
		throws PortalException {

		getOrganizationPermission().check(
			permissionChecker, organization, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long organizationId,
			String actionId)
		throws PortalException {

		return getOrganizationPermission().contains(
			permissionChecker, organizationId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long[] organizationIds,
			String actionId)
		throws PortalException {

		return getOrganizationPermission().contains(
			permissionChecker, organizationIds, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, Organization organization,
			String actionId)
		throws PortalException {

		return getOrganizationPermission().contains(
			permissionChecker, organization, actionId);
	}

	public static OrganizationPermission getOrganizationPermission() {
		return _organizationPermission;
	}

	public void setOrganizationPermission(
		OrganizationPermission organizationPermission) {

		_organizationPermission = organizationPermission;
	}

	private static OrganizationPermission _organizationPermission;

}