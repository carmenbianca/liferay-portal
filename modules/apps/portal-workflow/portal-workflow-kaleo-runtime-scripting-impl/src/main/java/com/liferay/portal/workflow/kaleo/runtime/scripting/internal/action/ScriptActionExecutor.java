/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.scripting.internal.action;

import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.action.executor.ActionExecutor;
import com.liferay.portal.workflow.kaleo.runtime.action.executor.ActionExecutorException;
import com.liferay.portal.workflow.kaleo.runtime.scripting.internal.util.KaleoScriptingEvaluator;
import com.liferay.portal.workflow.kaleo.runtime.util.WorkflowContextUtil;

import java.util.HashSet;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portal.workflow.kaleo.runtime.action.executor.language=beanshell",
		"com.liferay.portal.workflow.kaleo.runtime.action.executor.language=groovy",
		"com.liferay.portal.workflow.kaleo.runtime.action.executor.language=javascript",
		"com.liferay.portal.workflow.kaleo.runtime.action.executor.language=python",
		"com.liferay.portal.workflow.kaleo.runtime.action.executor.language=ruby"
	},
	service = ActionExecutor.class
)
public class ScriptActionExecutor implements ActionExecutor {

	public ScriptActionExecutor() {
		_outputObjects.add(WorkflowContextUtil.WORKFLOW_CONTEXT_NAME);
	}

	@Override
	public void execute(
			KaleoAction kaleoAction, ExecutionContext executionContext)
		throws ActionExecutorException {

		try {
			doExecute(kaleoAction, executionContext);
		}
		catch (Exception exception) {
			throw new ActionExecutorException(exception);
		}
	}

	public void setOutputObjects(Set<String> outputObjects) {
		_outputObjects.addAll(outputObjects);
	}

	protected void doExecute(
			KaleoAction kaleoAction, ExecutionContext executionContext)
		throws Exception {

		_kaleoScriptingEvaluator.execute(
			executionContext, _outputObjects, kaleoAction.getScriptLanguage(),
			kaleoAction.getScript());
	}

	@Reference
	private KaleoScriptingEvaluator _kaleoScriptingEvaluator;

	private final Set<String> _outputObjects = new HashSet<>();

}