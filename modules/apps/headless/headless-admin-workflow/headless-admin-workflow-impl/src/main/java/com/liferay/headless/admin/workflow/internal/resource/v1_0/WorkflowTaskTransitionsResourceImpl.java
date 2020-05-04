/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.admin.workflow.internal.resource.v1_0;

import com.liferay.headless.admin.workflow.dto.v1_0.Transition;
import com.liferay.headless.admin.workflow.dto.v1_0.WorkflowTaskTransition;
import com.liferay.headless.admin.workflow.dto.v1_0.WorkflowTaskTransitions;
import com.liferay.headless.admin.workflow.internal.dto.v1_0.util.TransitionUtil;
import com.liferay.headless.admin.workflow.resource.v1_0.WorkflowTaskTransitionsResource;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Inácio Nery
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/workflow-task-transitions.properties",
	scope = ServiceScope.PROTOTYPE,
	service = WorkflowTaskTransitionsResource.class
)
public class WorkflowTaskTransitionsResourceImpl
	extends BaseWorkflowTaskTransitionsResourceImpl {

	@Override
	public WorkflowTaskTransitions getWorkflowTaskTransition(
			Long[] workflowTaskIds)
		throws Exception {

		return new WorkflowTaskTransitions() {
			{
				setWorkflowTaskTransitions(
					() -> {
						List<WorkflowTaskTransition> workflowTaskTransitions =
							new ArrayList<>();

						for (Long workflowTaskId : workflowTaskIds) {
							workflowTaskTransitions.add(
								_createWorkflowTaskTransition(
									_workflowTaskManager.getNextTransitionNames(
										contextCompany.getCompanyId(),
										contextUser.getUserId(),
										workflowTaskId),
									_workflowTaskManager.getWorkflowTask(
										contextCompany.getCompanyId(),
										workflowTaskId)));
						}

						return workflowTaskTransitions.toArray(
							new WorkflowTaskTransition[0]);
					});
			}
		};
	}

	private WorkflowTaskTransition _createWorkflowTaskTransition(
		Collection<String> transitionNames, WorkflowTask workflowTask) {

		WorkflowTaskTransition workflowTaskTransition =
			new WorkflowTaskTransition();

		workflowTaskTransition.setTransitions(
			transformToArray(
				transitionNames,
				transitionName -> TransitionUtil.toTransition(
					_language, transitionName,
					ResourceBundleUtil.getModuleAndPortalResourceBundle(
						contextAcceptLanguage.getPreferredLocale(),
						WorkflowTaskTransitionsResourceImpl.class)),
				Transition.class));
		workflowTaskTransition.setWorkflowDefinitionVersion(
			String.valueOf(workflowTask.getWorkflowDefinitionVersion()));
		workflowTaskTransition.setWorkflowTaskLabel(
			_language.get(
				ResourceBundleUtil.getModuleAndPortalResourceBundle(
					contextAcceptLanguage.getPreferredLocale(),
					WorkflowTaskTransitionsResourceImpl.class),
				workflowTask.getName()));
		workflowTaskTransition.setWorkflowTaskName(workflowTask.getName());

		return workflowTaskTransition;
	}

	@Reference
	private Language _language;

	@Reference
	private WorkflowTaskManager _workflowTaskManager;

}