/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow.permission;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Jorge Ferrer
 */
public interface WorkflowPermission {

	public Boolean hasPermission(
		PermissionChecker permissionChecker, long groupId, String className,
		long classPK, String actionId);

}