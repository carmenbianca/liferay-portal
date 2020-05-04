/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.web.internal.struts;

import com.liferay.message.boards.constants.MBPortletKeys;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"javax.portlet.name=" + MBPortletKeys.MESSAGE_BOARDS,
		"javax.portlet.name=" + MBPortletKeys.MESSAGE_BOARDS_ADMIN,
		"path=/message_boards/find_recent_posts"
	},
	service = StrutsAction.class
)
public class FindRecentPostsStrutsAction implements StrutsAction {

	@Override
	public String execute(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		try {
			long plid = ParamUtil.getLong(httpServletRequest, "p_l_id");

			PortletURL portletURL = PortletURLFactoryUtil.create(
				httpServletRequest, MBPortletKeys.MESSAGE_BOARDS, plid,
				PortletRequest.RENDER_PHASE);

			portletURL.setParameter(
				"mvcRenderCommandName", "/message_boards/view_recent_posts");
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setWindowState(WindowState.NORMAL);

			httpServletResponse.sendRedirect(portletURL.toString());

			return null;
		}
		catch (Exception exception) {
			_portal.sendError(
				exception, httpServletRequest, httpServletResponse);

			return null;
		}
	}

	@Reference
	private Portal _portal;

}