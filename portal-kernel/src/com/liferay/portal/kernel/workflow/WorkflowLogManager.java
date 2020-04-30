/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import com.liferay.portal.kernel.messaging.proxy.MessagingProxy;
import com.liferay.portal.kernel.messaging.proxy.ProxyMode;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * @author Micha Kiener
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
@MessagingProxy(mode = ProxyMode.SYNC)
public interface WorkflowLogManager {

	public int getWorkflowLogCountByWorkflowInstance(
			long companyId, long workflowInstanceId, List<Integer> logTypes)
		throws WorkflowException;

	public int getWorkflowLogCountByWorkflowTask(
			long companyId, long workflowTaskId, List<Integer> logTypes)
		throws WorkflowException;

	public List<WorkflowLog> getWorkflowLogsByWorkflowInstance(
			long companyId, long workflowInstanceId, List<Integer> logTypes,
			int start, int end,
			OrderByComparator<WorkflowLog> orderByComparator)
		throws WorkflowException;

	public List<WorkflowLog> getWorkflowLogsByWorkflowTask(
			long companyId, long workflowTaskId, List<Integer> logTypes,
			int start, int end,
			OrderByComparator<WorkflowLog> orderByComparator)
		throws WorkflowException;

}