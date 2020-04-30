/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import java.io.Serializable;

/**
 * @author Michael C. Han
 */
public class WorkflowTaskAssignee implements Serializable {

	public WorkflowTaskAssignee(
		String assigneeClassName, long assigneeClassPK) {

		_assigneeClassName = assigneeClassName;
		_assigneeClassPK = assigneeClassPK;
	}

	public String getAssigneeClassName() {
		return _assigneeClassName;
	}

	public long getAssigneeClassPK() {
		return _assigneeClassPK;
	}

	private final String _assigneeClassName;
	private final long _assigneeClassPK;

}