/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.internal.assignment;

import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.assignment.TaskAssignmentSelector;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "assignee.class.name=com.liferay.portal.kernel.model.User",
	service = TaskAssignmentSelector.class
)
public class DefaultTaskAssignmentSelector implements TaskAssignmentSelector {

	@Override
	public Collection<KaleoTaskAssignment> calculateTaskAssignments(
		KaleoTaskAssignment kaleoTaskAssignment,
		ExecutionContext executionContext) {

		return ListUtil.fromArray(kaleoTaskAssignment);
	}

}