/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.scripting.internal.assignment;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.assignment.BaseTaskAssignmentSelector;
import com.liferay.portal.workflow.kaleo.runtime.assignment.TaskAssignmentSelector;
import com.liferay.portal.workflow.kaleo.runtime.scripting.internal.util.KaleoScriptingEvaluator;
import com.liferay.portal.workflow.kaleo.runtime.util.WorkflowContextUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = {
		"scripting.language=beanshell", "scripting.language=groovy",
		"scripting.language=javascript", "scripting.language=python",
		"scripting.language=ruby"
	},
	service = TaskAssignmentSelector.class
)
public class ScriptingLanguagesTaskAssignmentSelector
	extends BaseTaskAssignmentSelector {

	@Override
	public Collection<KaleoTaskAssignment> calculateTaskAssignments(
			KaleoTaskAssignment kaleoTaskAssignment,
			ExecutionContext executionContext)
		throws PortalException {

		String assigneeScript = kaleoTaskAssignment.getAssigneeScript();

		String assigneeScriptingLanguage =
			kaleoTaskAssignment.getAssigneeScriptLanguage();

		Map<String, Object> results = _kaleoScriptingEvaluator.execute(
			executionContext, _outputNames, assigneeScriptingLanguage,
			assigneeScript);

		return getKaleoTaskAssignments(results);
	}

	private static final Set<String> _outputNames = new HashSet<>(
		Arrays.asList(
			ROLES_ASSIGNMENT, USER_ASSIGNMENT,
			WorkflowContextUtil.WORKFLOW_CONTEXT_NAME));

	@Reference
	private KaleoScriptingEvaluator _kaleoScriptingEvaluator;

}