/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.exception;

import com.liferay.portal.kernel.workflow.WorkflowException;

/**
 * @author Rafael Praxedes
 */
public class IncompleteWorkflowInstancesException extends WorkflowException {

	public IncompleteWorkflowInstancesException() {
	}

	public IncompleteWorkflowInstancesException(int workflowInstancesCount) {
		_workflowInstancesCount = workflowInstancesCount;
	}

	public IncompleteWorkflowInstancesException(String msg) {
		super(msg);
	}

	public IncompleteWorkflowInstancesException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public IncompleteWorkflowInstancesException(Throwable cause) {
		super(cause);
	}

	public int getWorkflowInstancesCount() {
		return _workflowInstancesCount;
	}

	private int _workflowInstancesCount;

}