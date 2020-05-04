/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.integration.internal.util;

import com.liferay.portal.kernel.workflow.WorkflowTaskAssignee;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Marcellus Tavares
 */
public class FirstWorkflowTaskAssigneeSupplier
	implements Supplier<Optional<WorkflowTaskAssignee>> {

	public FirstWorkflowTaskAssigneeSupplier(
		KaleoTaskInstanceToken kaleoTaskInstanceToken) {

		_kaleoTaskInstanceToken = kaleoTaskInstanceToken;
	}

	@Override
	public Optional<WorkflowTaskAssignee> get() {
		return Optional.ofNullable(
			_kaleoTaskInstanceToken.getFirstKaleoTaskAssignmentInstance()
		).map(
			kaleoTaskAssignmentInstance -> new WorkflowTaskAssignee(
				kaleoTaskAssignmentInstance.getAssigneeClassName(),
				kaleoTaskAssignmentInstance.getAssigneeClassPK())
		);
	}

	private final KaleoTaskInstanceToken _kaleoTaskInstanceToken;

}