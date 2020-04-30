/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Adolfo Pérez
 */
public interface LayoutTypeAccessPolicy extends Serializable {

	public void checkAccessAllowedToPortlet(
			HttpServletRequest httpServletRequest, Layout layout,
			Portlet portlet)
		throws PortalException;

	public boolean isAddLayoutAllowed(
			PermissionChecker permissionChecker, Layout layout)
		throws PortalException;

	public boolean isCustomizeLayoutAllowed(
			PermissionChecker permissionChecker, Layout layout)
		throws PortalException;

	public boolean isDeleteLayoutAllowed(
			PermissionChecker permissionChecker, Layout layout)
		throws PortalException;

	public boolean isUpdateLayoutAllowed(
			PermissionChecker permissionChecker, Layout layout)
		throws PortalException;

	public boolean isViewLayoutAllowed(
			PermissionChecker permissionChecker, Layout layout)
		throws PortalException;

}