/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.portlet;

import com.liferay.portal.kernel.portlet.ControlPanelEntry;
import com.liferay.portal.workflow.WorkflowControlPanelEntry;
import com.liferay.portal.workflow.constants.WorkflowPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adam Brandizzi
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + WorkflowPortletKeys.SITE_ADMINISTRATION_WORKFLOW,
	service = ControlPanelEntry.class
)
public class SiteAdministrationWorkflowControlPanelEntry
	extends WorkflowControlPanelEntry {
}