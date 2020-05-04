/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.security.permission.resource;

import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portlet.documentlibrary.constants.DLConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(service = {})
public class DLPermission {

	public static void check(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws PrincipalException {

		_portletResourcePermission.check(permissionChecker, classPK, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long classPK, String actionId) {

		return _portletResourcePermission.contains(
			permissionChecker, classPK, actionId);
	}

	@Reference(
		target = "(resource.name=" + DLConstants.RESOURCE_NAME + ")",
		unbind = "-"
	)
	protected void setPortletResourcePermission(
		PortletResourcePermission portletResourcePermission) {

		_portletResourcePermission = portletResourcePermission;
	}

	private static PortletResourcePermission _portletResourcePermission;

}