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
 */
public interface WorkflowInstance {

	public void addChildWorkflowInstance(
		WorkflowInstance childWorkflowInstance);

	public int getChildrenWorkflowInstanceCount();

	public List<WorkflowInstance> getChildrenWorkflowInstances();

	public Date getEndDate();

	public WorkflowInstance getParentWorkflowInstance();

	public long getParentWorkflowInstanceId();

	public Date getStartDate();

	public String getState();

	public Map<String, Serializable> getWorkflowContext();

	public String getWorkflowDefinitionName();

	public int getWorkflowDefinitionVersion();

	public long getWorkflowInstanceId();

	public boolean isComplete();

	public void setParentWorkflowInstance(
		WorkflowInstance parentWorkflowInstance);

}