/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.workflow.constants.WorkflowPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adam Brandizzi
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=400",
		"panel.category.key=" + PanelCategoryKeys.USER_MY_ACCOUNT
	},
	service = PanelApp.class
)
public class UserWorkflowPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return WorkflowPortletKeys.USER_WORKFLOW;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + WorkflowPortletKeys.USER_WORKFLOW + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}