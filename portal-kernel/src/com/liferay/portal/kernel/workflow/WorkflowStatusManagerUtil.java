/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Bruno Farache
 * @author Raymond Augé
 */
public class WorkflowStatusManagerUtil {

	public static WorkflowStatusManager getWorkflowStatusManager() {
		return _workflowStatusManager;
	}

	public static void updateStatus(
			int status, Map<String, Serializable> workflowContext)
		throws WorkflowException {

		getWorkflowStatusManager().updateStatus(status, workflowContext);
	}

	public void setWorkflowStatusManager(
		WorkflowStatusManager workflowStatusManager) {

		_workflowStatusManager = workflowStatusManager;
	}

	private static WorkflowStatusManager _workflowStatusManager;

}