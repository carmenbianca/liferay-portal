/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.aui;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.taglib.aui.base.BaseWorkflowStatusTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Julio Camarero
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 */
public class WorkflowStatusTag extends BaseWorkflowStatusTag {

	@Override
	protected String getPage() {
		String markupView = getMarkupView();

		if (Validator.isNotNull(markupView)) {
			return "/html/taglib/aui/workflow_status/" + markupView +
				"/page.jsp";
		}

		return "/html/taglib/aui/workflow_status/page.jsp";
	}

	@Override
	protected boolean isCleanUpSetAttributes() {
		return _CLEAN_UP_SET_ATTRIBUTES;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		super.setAttributes(httpServletRequest);

		Object bean = getBean();

		if (bean == null) {
			bean = pageContext.getAttribute("aui:model-context:bean");
		}

		String helpMessage = getHelpMessage();

		if (Validator.isNull(helpMessage) &&
			(getStatus() == WorkflowConstants.STATUS_APPROVED) &&
			Validator.isNotNull(getVersion())) {

			helpMessage = _HELP_MESSAGE_DEFAULT;
		}

		Class<?> model = getModel();

		if (model == null) {
			model = (Class<?>)pageContext.getAttribute(
				"aui:model-context:model");
		}

		setNamespacedAttribute(httpServletRequest, "bean", bean);
		setNamespacedAttribute(httpServletRequest, "helpMessage", helpMessage);
		setNamespacedAttribute(httpServletRequest, "model", model);
	}

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

	private static final String _HELP_MESSAGE_DEFAULT =
		"a-new-version-is-created-automatically-if-this-content-is-modified";

}