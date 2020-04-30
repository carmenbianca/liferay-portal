/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Michael C. Han
 */
public enum LogType {

	ACTION_EXECUTION, NODE_ENTRY, NODE_EXIT, TASK_ASSIGNMENT, TASK_COMPLETION,
	TASK_UPDATE, WORKFLOW_INSTANCE_END, WORKFLOW_INSTANCE_START

}