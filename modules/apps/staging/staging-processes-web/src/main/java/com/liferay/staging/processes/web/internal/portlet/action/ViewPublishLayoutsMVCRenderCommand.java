/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.staging.processes.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.staging.constants.StagingProcessesPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Daniel Kocsis
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StagingProcessesPortletKeys.STAGING_PROCESSES,
		"mvc.command.name=viewPublishLayouts"
	},
	service = MVCRenderCommand.class
)
public class ViewPublishLayoutsMVCRenderCommand
	extends GetGroupMVCRenderCommand {

	@Override
	protected String getPath() {
		return "/view.jsp";
	}

}