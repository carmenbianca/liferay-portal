/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.workflow.web.internal.search.WorkflowDefinitionLinkSearchEntry;

/**
 * @author Leonardo Barros
 */
public class WorkflowDefinitionLinkSearchEntryWorkflowComparator
	extends OrderByComparator<WorkflowDefinitionLinkSearchEntry> {

	public WorkflowDefinitionLinkSearchEntryWorkflowComparator(
		boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(
		WorkflowDefinitionLinkSearchEntry workflowDefinitionLinkSearchEntry1,
		WorkflowDefinitionLinkSearchEntry workflowDefinitionLinkSearchEntry2) {

		String workflowDefinitionLabel1 = StringUtil.toLowerCase(
			workflowDefinitionLinkSearchEntry1.getWorkflowDefinitionLabel());
		String workflowDefinitionLabel2 = StringUtil.toLowerCase(
			workflowDefinitionLinkSearchEntry2.getWorkflowDefinitionLabel());

		int value = workflowDefinitionLabel1.compareTo(
			workflowDefinitionLabel2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	private final boolean _ascending;

}