/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Charles May
 */
public interface OrganizationPermission {

	public void check(
			PermissionChecker permissionChecker, long organizationId,
			String actionId)
		throws PortalException;

	public void check(
			PermissionChecker permissionChecker, Organization organization,
			String actionId)
		throws PortalException;

	public boolean contains(
			PermissionChecker permissionChecker, long organizationId,
			String actionId)
		throws PortalException;

	public boolean contains(
			PermissionChecker permissionChecker, long[] organizationIds,
			String actionId)
		throws PortalException;

	public boolean contains(
			PermissionChecker permissionChecker, Organization organization,
			String actionId)
		throws PortalException;

}