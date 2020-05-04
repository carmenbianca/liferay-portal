/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow.comparator;

import com.liferay.portal.kernel.messaging.proxy.MessagingProxy;
import com.liferay.portal.kernel.messaging.proxy.ProxyMode;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowTask;

/**
 * @author Michael C. Han
 */
@MessagingProxy(mode = ProxyMode.SYNC)
public interface WorkflowComparatorFactory {

	public OrderByComparator<WorkflowDefinition> getDefinitionNameComparator(
		boolean ascending);

	public OrderByComparator<WorkflowInstance> getInstanceCompletedComparator(
		boolean ascending);

	public OrderByComparator<WorkflowInstance> getInstanceEndDateComparator(
		boolean ascending);

	public OrderByComparator<WorkflowInstance> getInstanceStartDateComparator(
		boolean ascending);

	public OrderByComparator<WorkflowInstance> getInstanceStateComparator(
		boolean ascending);

	public OrderByComparator<WorkflowLog> getLogCreateDateComparator(
		boolean ascending);

	public OrderByComparator<WorkflowLog> getLogUserIdComparator(
		boolean ascending);

	public OrderByComparator<WorkflowTask> getTaskCompletionDateComparator(
		boolean ascending);

	public OrderByComparator<WorkflowTask> getTaskCreateDateComparator(
		boolean ascending);

	public OrderByComparator<WorkflowTask> getTaskDueDateComparator(
		boolean ascending);

	public default OrderByComparator<WorkflowTask> getTaskInstanceIdComparator(
		boolean ascending) {

		throw new UnsupportedOperationException();
	}

	public default OrderByComparator<WorkflowTask>
		getTaskModifiedDateComparator(boolean ascending) {

		throw new UnsupportedOperationException();
	}

	public OrderByComparator<WorkflowTask> getTaskNameComparator(
		boolean ascending);

	public OrderByComparator<WorkflowTask> getTaskUserIdComparator(
		boolean ascending);

}