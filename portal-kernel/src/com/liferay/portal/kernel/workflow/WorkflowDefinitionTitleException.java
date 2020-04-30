/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

/**
 * @author Inácio Nery
 */
public class WorkflowDefinitionTitleException extends WorkflowException {

	public WorkflowDefinitionTitleException() {
	}

	public WorkflowDefinitionTitleException(String msg) {
		super(msg);
	}

	public WorkflowDefinitionTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WorkflowDefinitionTitleException(Throwable cause) {
		super(cause);
	}

}