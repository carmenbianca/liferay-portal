/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.rule;

import com.liferay.mobile.device.rules.model.MDRRuleGroupInstance;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Collection;

/**
 * @author Edward Han
 */
public interface RuleGroupProcessor {

	public MDRRuleGroupInstance evaluateRuleGroups(ThemeDisplay themeDisplay);

	public RuleHandler getRuleHandler(String ruleType);

	public Collection<RuleHandler> getRuleHandlers();

	public Collection<String> getRuleHandlerTypes();

	public void registerRuleHandler(RuleHandler ruleHandler);

	public RuleHandler unregisterRuleHandler(String ruleType);

}