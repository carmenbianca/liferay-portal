/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.scripting.internal.component.enabler;

import com.liferay.osgi.util.ComponentUtil;
import com.liferay.portal.rules.engine.RulesEngine;
import com.liferay.portal.workflow.kaleo.runtime.scripting.internal.action.DRLActionExecutor;
import com.liferay.portal.workflow.kaleo.runtime.scripting.internal.assignment.DRLScriptingTaskAssignmentSelector;
import com.liferay.portal.workflow.kaleo.runtime.scripting.internal.condition.DRLConditionEvaluator;
import com.liferay.portal.workflow.kaleo.runtime.scripting.internal.notification.recipient.script.DRLNotificationRecipientEvaluator;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = {})
public class ComponentEnabler {

	@Activate
	protected void activate(ComponentContext componentContext) {
		ComponentUtil.enableComponents(
			RulesEngine.class, null, componentContext, DRLActionExecutor.class,
			DRLConditionEvaluator.class,
			DRLNotificationRecipientEvaluator.class,
			DRLScriptingTaskAssignmentSelector.class);
	}

}