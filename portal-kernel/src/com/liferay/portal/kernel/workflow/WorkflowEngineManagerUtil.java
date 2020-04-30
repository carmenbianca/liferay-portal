/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class WorkflowEngineManagerUtil {

	public static String getKey() {
		return getWorkflowEngineManager().getKey();
	}

	public static String getName() {
		return getWorkflowEngineManager().getName();
	}

	public static Map<String, Object> getOptionalAttributes() {
		return getWorkflowEngineManager().getOptionalAttributes();
	}

	public static String getVersion() {
		return getWorkflowEngineManager().getVersion();
	}

	public static WorkflowEngineManager getWorkflowEngineManager() {
		return _workflowEngineManager;
	}

	public static boolean isDeployed() {
		return getWorkflowEngineManager().isDeployed();
	}

	public void setWorkflowEngineManager(
		WorkflowEngineManager workflowEngineManager) {

		_workflowEngineManager = workflowEngineManager;
	}

	private static WorkflowEngineManager _workflowEngineManager;

}