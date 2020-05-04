/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.application;

import com.liferay.depot.application.DepotApplication;
import com.liferay.portal.workflow.constants.WorkflowPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = DepotApplication.class)
public class ControlPanelWorkflowDepotApplication implements DepotApplication {

	@Override
	public String getPortletId() {
		return WorkflowPortletKeys.CONTROL_PANEL_WORKFLOW;
	}

}