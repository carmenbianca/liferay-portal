/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission.propagator;

import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.ActionRequest;

/**
 * @author Hugo Huijser
 */
public interface PermissionPropagator {

	public void propagateRolePermissions(
			ActionRequest actionRequest, String className, String primKey,
			long[] roleIds)
		throws PortalException;

}