/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Micha Kiener
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 * @author Marcellus Tavares
 */
public interface WorkflowTask {

	public long getAssigneeUserId();

	public Date getCompletionDate();

	public Date getCreateDate();

	public String getDescription();

	public Date getDueDate();

	public String getName();

	public Map<String, Serializable> getOptionalAttributes();

	public long getWorkflowDefinitionId();

	public String getWorkflowDefinitionName();

	public int getWorkflowDefinitionVersion();

	public long getWorkflowInstanceId();

	public List<WorkflowTaskAssignee> getWorkflowTaskAssignees();

	public long getWorkflowTaskId();

	public boolean isAssignedToSingleUser();

	public boolean isAsynchronous();

	public boolean isCompleted();

}