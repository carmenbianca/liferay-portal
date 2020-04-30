/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.security.wedeploy.auth.web.internal.constants.WeDeployAuthPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Supritha Sundaram
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + WeDeployAuthPortletKeys.WEDEPLOY_AUTH_ADMIN,
		"mvc.command.name=/", "mvc.command.name=/wedeploy_auth_admin/view"
	},
	service = MVCRenderCommand.class
)
public class WeDeployAuthAdminViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/wedeploy_auth_admin/view.jsp";
	}

}