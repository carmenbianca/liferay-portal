/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.task.web.internal.dao.search;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.ResultRowSplitter;
import com.liferay.portal.kernel.dao.search.ResultRowSplitterEntry;
import com.liferay.portal.kernel.workflow.WorkflowTask;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Inácio Nery
 */
public class WorkflowTaskResultRowSplitter implements ResultRowSplitter {

	@Override
	public List<ResultRowSplitterEntry> split(List<ResultRow> resultRows) {
		List<ResultRowSplitterEntry> resultRowSplitterEntries =
			new ArrayList<>();

		List<ResultRow> workflowTaskCompletedResultRows = new ArrayList<>();
		List<ResultRow> workflowTaskPendingResultRows = new ArrayList<>();

		for (ResultRow resultRow : resultRows) {
			WorkflowTask workflowTask = (WorkflowTask)resultRow.getObject();

			if (workflowTask.isCompleted()) {
				workflowTaskCompletedResultRows.add(resultRow);
			}
			else {
				workflowTaskPendingResultRows.add(resultRow);
			}
		}

		if (!workflowTaskPendingResultRows.isEmpty()) {
			resultRowSplitterEntries.add(
				new ResultRowSplitterEntry(
					"pending", workflowTaskPendingResultRows));
		}

		if (!workflowTaskCompletedResultRows.isEmpty()) {
			resultRowSplitterEntries.add(
				new ResultRowSplitterEntry(
					"completed", workflowTaskCompletedResultRows));
		}

		return resultRowSplitterEntries;
	}

}