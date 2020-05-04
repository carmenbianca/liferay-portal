/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.content.page.editor.web.internal.workflow;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFunction;
import com.liferay.portal.kernel.workflow.WorkflowThreadLocal;

import java.util.function.Function;

import javax.portlet.ActionRequest;

/**
 * @author Alejandro Tardín
 */
public class WorkflowUtil {

	public static Function<String, ServiceContext> getServiceContextFunction(
		int workflowAction, ActionRequest actionRequest) {

		Function<String, ServiceContext> serviceContextFunction =
			new ServiceContextFunction(actionRequest);

		return serviceContextFunction.andThen(
			serviceContext -> {
				serviceContext.setWorkflowAction(workflowAction);

				return serviceContext;
			});
	}

	public static <E extends Exception> void withoutWorkflow(
			UnsafeRunnable<E> unsafeRunnable)
		throws E {

		boolean workflowEnabled = WorkflowThreadLocal.isEnabled();

		WorkflowThreadLocal.setEnabled(false);

		try {
			unsafeRunnable.run();
		}
		finally {
			WorkflowThreadLocal.setEnabled(workflowEnabled);
		}
	}

}