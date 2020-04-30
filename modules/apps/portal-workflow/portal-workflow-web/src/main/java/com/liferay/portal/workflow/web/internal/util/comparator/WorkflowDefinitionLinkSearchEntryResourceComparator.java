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
public class WorkflowDefinitionLinkSearchEntryResourceComparator
	extends OrderByComparator<WorkflowDefinitionLinkSearchEntry> {

	public WorkflowDefinitionLinkSearchEntryResourceComparator(
		boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(
		WorkflowDefinitionLinkSearchEntry workflowDefinitionLinkSearchEntry1,
		WorkflowDefinitionLinkSearchEntry workflowDefinitionLinkSearchEntry2) {

		String resource1 = StringUtil.toLowerCase(
			workflowDefinitionLinkSearchEntry1.getResource());
		String resource2 = StringUtil.toLowerCase(
			workflowDefinitionLinkSearchEntry2.getResource());

		int value = resource1.compareTo(resource2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	private final boolean _ascending;

}