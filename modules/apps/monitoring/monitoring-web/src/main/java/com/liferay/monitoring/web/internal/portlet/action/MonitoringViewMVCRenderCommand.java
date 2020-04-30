/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.monitoring.web.internal.portlet.action;

import com.liferay.monitoring.web.internal.constants.MonitoringPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Philip Jones
 */
@Component(
	property = {
		"javax.portlet.name=" + MonitoringPortletKeys.MONITORING,
		"mvc.command.name=/monitoring/view"
	},
	service = MVCRenderCommand.class
)
public class MonitoringViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		return "/view.jsp";
	}

}