/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.display.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

import java.util.List;

/**
 * @author Marcellus Tavares
 */
public class MyWorkflowInstanceEditDisplayContext
	extends WorkflowInstanceEditDisplayContext {

	public MyWorkflowInstanceEditDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	@Override
	public List<WorkflowTask> getWorkflowTasks() throws PortalException {
		if (workflowTasks == null) {
			workflowTasks =
				WorkflowTaskManagerUtil.getWorkflowTasksByWorkflowInstance(
					workflowInstanceRequestHelper.getCompanyId(),
					workflowInstanceRequestHelper.getUserId(),
					getWorkflowInstanceId(), false, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null);
		}

		return workflowTasks;
	}

}