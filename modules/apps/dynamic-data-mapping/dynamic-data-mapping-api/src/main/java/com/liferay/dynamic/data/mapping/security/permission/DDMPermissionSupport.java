/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.security.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Rafael Praxedes
 */
public interface DDMPermissionSupport {

	public void checkAddStructurePermission(
			PermissionChecker permissionChecker, long groupId, long classNameId)
		throws PortalException;

	public void checkAddTemplatePermission(
			PermissionChecker permissionChecker, long groupId, long classNameId,
			long resourceClassNameId)
		throws PortalException;

	public void checkAddTemplatePermission(
			PermissionChecker permissionChecker, long groupId, long classNameId,
			String resourceClassName)
		throws PortalException;

	public boolean containsAddStructurePermission(
			PermissionChecker permissionChecker, long groupId, long classNameId)
		throws PortalException;

	public boolean containsAddTemplatePermission(
			PermissionChecker permissionChecker, long groupId, long classNameId,
			long resourceClassNameId)
		throws PortalException;

	public boolean containsAddTemplatePermission(
			PermissionChecker permissionChecker, long groupId, long classNameId,
			String resourceClassName)
		throws PortalException;

	public String getStructureModelResourceName(long classNameId)
		throws PortalException;

	public String getStructureModelResourceName(String className)
		throws PortalException;

	public String getTemplateModelResourceName(long resourceClassNameId)
		throws PortalException;

	public String getTemplateModelResourceName(String resourceClassName)
		throws PortalException;

}