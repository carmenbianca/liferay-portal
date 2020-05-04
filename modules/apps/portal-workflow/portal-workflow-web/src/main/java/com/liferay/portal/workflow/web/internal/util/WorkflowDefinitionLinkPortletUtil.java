/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.workflow.web.internal.search.WorkflowDefinitionLinkSearchEntry;
import com.liferay.portal.workflow.web.internal.util.comparator.WorkflowDefinitionLinkSearchEntryResourceComparator;
import com.liferay.portal.workflow.web.internal.util.comparator.WorkflowDefinitionLinkSearchEntryWorkflowComparator;

/**
 * @author Leonardo Barros
 */
public class WorkflowDefinitionLinkPortletUtil {

	public static OrderByComparator<WorkflowDefinitionLinkSearchEntry>
		getWorkflowDefinitionLinkOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<WorkflowDefinitionLinkSearchEntry> orderByComparator =
			null;

		if (orderByCol.equals("resource")) {
			orderByComparator =
				new WorkflowDefinitionLinkSearchEntryResourceComparator(
					orderByAsc);
		}
		else if (orderByCol.equals("workflow")) {
			orderByComparator =
				new WorkflowDefinitionLinkSearchEntryWorkflowComparator(
					orderByAsc);
		}

		return orderByComparator;
	}

}