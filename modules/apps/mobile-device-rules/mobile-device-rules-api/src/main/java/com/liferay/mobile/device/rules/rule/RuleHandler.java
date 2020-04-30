/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.rule;

import com.liferay.mobile.device.rules.model.MDRRule;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Collection;

/**
 * @author Edward Han
 */
public interface RuleHandler {

	public boolean evaluateRule(MDRRule mdrRule, ThemeDisplay themeDisplay);

	public String getEditorJSP();

	public Collection<String> getPropertyNames();

	public String getType();

}