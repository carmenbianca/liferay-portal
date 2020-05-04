/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.web.internal.portlet.action;

import com.liferay.announcements.constants.AnnouncementsPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Thiago Moreira
 * @author Raymond Augé
 */
@Component(
	property = {
		"javax.portlet.name=" + AnnouncementsPortletKeys.ALERTS,
		"javax.portlet.name=" + AnnouncementsPortletKeys.ANNOUNCEMENTS,
		"mvc.command.name=/", "mvc.command.name=/alerts/view",
		"mvc.command.name=/announcements/view"
	},
	service = MVCRenderCommand.class
)
public class AnnouncementsViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		return "/announcements/view.jsp";
	}

}