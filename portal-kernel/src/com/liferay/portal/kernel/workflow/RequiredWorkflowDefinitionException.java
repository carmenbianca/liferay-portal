/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import com.liferay.portal.kernel.model.WorkflowDefinitionLink;

import java.util.List;

/**
 * @author Marcellus Tavares
 */
public class RequiredWorkflowDefinitionException extends WorkflowException {

	public RequiredWorkflowDefinitionException() {
	}

	public RequiredWorkflowDefinitionException(
		List<WorkflowDefinitionLink> workflowDefinitionLinks) {

		_workflowDefinitionLinks = workflowDefinitionLinks;
	}

	public RequiredWorkflowDefinitionException(String msg) {
		super(msg);
	}

	public RequiredWorkflowDefinitionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredWorkflowDefinitionException(Throwable cause) {
		super(cause);
	}

	public List<WorkflowDefinitionLink> getWorkflowDefinitionLinks() {
		return _workflowDefinitionLinks;
	}

	private List<WorkflowDefinitionLink> _workflowDefinitionLinks;

}