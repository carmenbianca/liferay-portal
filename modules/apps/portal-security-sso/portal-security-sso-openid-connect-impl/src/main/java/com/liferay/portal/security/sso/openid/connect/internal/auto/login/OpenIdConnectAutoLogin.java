/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect.internal.auto.login;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnect;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectFlowState;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectSession;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectWebKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = AutoLogin.class)
public class OpenIdConnectAutoLogin extends BaseAutoLogin {

	@Override
	protected String[] doLogin(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		if (!_openIdConnect.isEnabled(
				_portal.getCompanyId(httpServletRequest))) {

			return null;
		}

		HttpSession httpSession = httpServletRequest.getSession(false);

		if (httpSession == null) {
			return null;
		}

		OpenIdConnectSession openIdConnectSession =
			(OpenIdConnectSession)httpSession.getAttribute(
				OpenIdConnectWebKeys.OPEN_ID_CONNECT_SESSION);

		if (openIdConnectSession == null) {
			return null;
		}

		if (OpenIdConnectFlowState.AUTH_COMPLETE.equals(
				openIdConnectSession.getOpenIdConnectFlowState())) {

			long userId = openIdConnectSession.getLoginUserId();

			User user = _userLocalService.getUserById(userId);

			String[] credentials = new String[3];

			credentials[0] = String.valueOf(user.getUserId());
			credentials[1] = user.getPassword();
			credentials[2] = Boolean.TRUE.toString();

			openIdConnectSession.setOpenIdConnectFlowState(
				OpenIdConnectFlowState.PORTAL_AUTH_COMPLETE);

			return credentials;
		}

		return null;
	}

	@Reference
	private OpenIdConnect _openIdConnect;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}