/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.login.authentication.openid.connect.web.internal.portlet.action;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnect;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectProviderRegistry;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectWebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Enables the Sign In portlet to render a prompt for users to enter their
 * OpenID Connect IDs.
 *
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.FAST_LOGIN,
		"javax.portlet.name=" + PortletKeys.LOGIN,
		"mvc.command.name=" + OpenIdConnectWebKeys.OPEN_ID_CONNECT_REQUEST_ACTION_NAME
	},
	service = MVCRenderCommand.class
)
public class OpenIdConnectLoginRequestMVCRenderCommand
	implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(
			renderRequest);

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (!_openIdConnect.isEnabled(themeDisplay.getCompanyId()) ||
			themeDisplay.isSignedIn()) {

			return "/login.jsp";
		}

		httpServletRequest.setAttribute(
			OpenIdConnectWebKeys.OPEN_ID_CONNECT_PROVIDER_NAMES,
			_openIdConnectProviderRegistry.getOpenIdConnectProviderNames());

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(_JSP_PATH);

		HttpServletResponse httpServletResponse =
			_portal.getHttpServletResponse(renderResponse);

		try {
			requestDispatcher.include(httpServletRequest, httpServletResponse);
		}
		catch (Exception exception) {
			_log.error(
				StringBundler.concat(
					"Unable to include JSP ", _JSP_PATH, ": ",
					exception.getMessage()),
				exception);

			throw new PortletException(
				"Unable to include JSP " + _JSP_PATH, exception);
		}

		return "/navigation.jsp";
	}

	private static final String _JSP_PATH =
		"/com.liferay.login.web/openid_connect.jsp";

	private static final Log _log = LogFactoryUtil.getLog(
		OpenIdConnectLoginRequestMVCRenderCommand.class);

	@Reference
	private OpenIdConnect _openIdConnect;

	@Reference
	private OpenIdConnectProviderRegistry _openIdConnectProviderRegistry;

	@Reference
	private Portal _portal;

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.login.authentication.openid.connect.web)"
	)
	private ServletContext _servletContext;

}