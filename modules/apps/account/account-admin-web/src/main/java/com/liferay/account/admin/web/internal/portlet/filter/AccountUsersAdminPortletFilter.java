/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.portlet.filter;

import com.liferay.account.constants.AccountPortletKeys;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.users.admin.constants.UsersAdminPortletKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + AccountPortletKeys.ACCOUNT_USERS_ADMIN,
	service = PortletFilter.class
)
public class AccountUsersAdminPortletFilter
	implements ActionFilter, RenderFilter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(
			ActionRequest actionRequest, ActionResponse actionResponse,
			FilterChain filterChain)
		throws IOException, PortletException {

		String actionName = ParamUtil.getString(
			actionRequest, ActionRequest.ACTION_NAME);

		if (Validator.isNotNull(actionName) &&
			actionName.startsWith("/users_admin/")) {

			_portlet.processAction(actionRequest, actionResponse);

			return;
		}

		filterChain.doFilter(actionRequest, actionResponse);
	}

	@Override
	public void doFilter(
			RenderRequest renderRequest, RenderResponse renderResponse,
			FilterChain filterChain)
		throws IOException, PortletException {

		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");

		if (Validator.isNotNull(mvcPath) && mvcPath.startsWith("/common/")) {
			_jspRenderer.renderJSP(
				_servletContext, _portal.getHttpServletRequest(renderRequest),
				_portal.getHttpServletResponse(renderResponse), mvcPath);

			return;
		}

		filterChain.doFilter(renderRequest, renderResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Reference
	private JSPRenderer _jspRenderer;

	@Reference
	private Portal _portal;

	@Reference(
		target = "(javax.portlet.name=" + UsersAdminPortletKeys.USERS_ADMIN + ")",
		unbind = "-"
	)
	private Portlet _portlet;

	@Reference(target = "(osgi.web.symbolicname=com.liferay.users.admin.web)")
	private ServletContext _servletContext;

}