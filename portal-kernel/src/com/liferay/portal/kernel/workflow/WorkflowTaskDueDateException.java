/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

/**
 * @author Brian Wing Shun Chan
 */
public class WorkflowTaskDueDateException extends WorkflowException {

	public WorkflowTaskDueDateException() {
	}

	public WorkflowTaskDueDateException(String msg) {
		super(msg);
	}

	public WorkflowTaskDueDateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WorkflowTaskDueDateException(Throwable cause) {
		super(cause);
	}

}