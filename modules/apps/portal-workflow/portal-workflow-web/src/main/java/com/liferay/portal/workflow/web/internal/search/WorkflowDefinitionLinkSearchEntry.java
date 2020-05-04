/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.search;

/**
 * @author Leonardo Barros
 */
public class WorkflowDefinitionLinkSearchEntry {

	public WorkflowDefinitionLinkSearchEntry(
		String className, String resource, String workflowDefinitionLabel) {

		_className = className;
		_resource = resource;
		_workflowDefinitionLabel = workflowDefinitionLabel;
	}

	public String getClassName() {
		return _className;
	}

	public String getResource() {
		return _resource;
	}

	public String getWorkflowDefinitionLabel() {
		return _workflowDefinitionLabel;
	}

	private final String _className;
	private final String _resource;
	private final String _workflowDefinitionLabel;

}