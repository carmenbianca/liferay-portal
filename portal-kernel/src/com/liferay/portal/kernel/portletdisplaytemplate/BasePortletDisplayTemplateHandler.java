/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portletdisplaytemplate;

import com.liferay.portal.kernel.template.BaseTemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;

import java.util.Locale;
import java.util.Map;

/**
 * @author Eduardo García
 */
public abstract class BasePortletDisplayTemplateHandler
	extends BaseTemplateHandler {

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale)
		throws Exception {

		return PortletDisplayTemplateManagerUtil.getTemplateVariableGroups(
			language);
	}

	@Override
	public boolean isDisplayTemplateHandler() {
		return true;
	}

}