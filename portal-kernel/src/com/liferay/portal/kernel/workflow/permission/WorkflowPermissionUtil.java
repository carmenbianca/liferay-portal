/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow.permission;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Jorge Ferrer
 */
public class WorkflowPermissionUtil {

	public static WorkflowPermission getWorkflowPermission() {
		return _workflowPermission;
	}

	public static Boolean hasPermission(
		PermissionChecker permissionChecker, long groupId, String className,
		long classPK, String actionId) {

		return getWorkflowPermission().hasPermission(
			permissionChecker, groupId, className, classPK, actionId);
	}

	public void setWorkflowPermission(WorkflowPermission workflowPermission) {
		_workflowPermission = workflowPermission;
	}

	private static WorkflowPermission _workflowPermission;

}