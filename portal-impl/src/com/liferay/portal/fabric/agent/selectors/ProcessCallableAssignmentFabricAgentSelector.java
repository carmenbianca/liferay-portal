/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.agent.selectors;

import com.liferay.petra.process.ProcessCallable;
import com.liferay.petra.string.StringPool;

import java.util.Map;

/**
 * @author Shuyang Zhou
 */
public class ProcessCallableAssignmentFabricAgentSelector
	extends SystemPropertiesFilterFabricAgentSelector {

	public static final String PROCESS_CALLABLE_ASSIGNMENT_EXPRESSION_KEY =
		ProcessCallableAssignmentFabricAgentSelector.class.getName() +
			StringPool.POUND + "processCallableAssignmentExpressionKey";

	@Override
	protected boolean accept(
		Map<String, String> systemProperties,
		ProcessCallable<?> processCallable) {

		String processCallableAssignmentExpressionValue = systemProperties.get(
			PROCESS_CALLABLE_ASSIGNMENT_EXPRESSION_KEY);

		if (processCallableAssignmentExpressionValue == null) {
			return false;
		}

		Class<?> clazz = processCallable.getClass();

		String className = clazz.getName();

		return className.matches(processCallableAssignmentExpressionValue);
	}

}