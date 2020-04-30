/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.web.internal.display.context;

import com.liferay.document.library.util.DLURLHelper;
import com.liferay.oauth2.provider.model.OAuth2Authorization;
import com.liferay.oauth2.provider.service.OAuth2ApplicationService;
import com.liferay.oauth2.provider.web.internal.AssignableScopes;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;

/**
 * @author Tomas Polesovsky
 */
public class OAuth2ConnectedApplicationsPortletDisplayContext
	extends BaseOAuth2PortletDisplayContext {

	public OAuth2ConnectedApplicationsPortletDisplayContext(
		AssignableScopes assignableScopes, PortletRequest portletRequest,
		OAuth2ApplicationService oAuth2ApplicationService,
		OAuth2Authorization oAuth2Authorization, DLURLHelper dlURLHelper) {

		this(portletRequest, dlURLHelper);

		_assignableScopes = assignableScopes;
		_oAuth2Authorization = oAuth2Authorization;

		super.oAuth2ApplicationService = oAuth2ApplicationService;
		super.dlURLHelper = dlURLHelper;
	}

	public OAuth2ConnectedApplicationsPortletDisplayContext(
		PortletRequest portletRequest, DLURLHelper dlURLHelper) {

		this.dlURLHelper = dlURLHelper;

		super.portletRequest = portletRequest;

		super.themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public AssignableScopes getAssignableScopes() {
		return _assignableScopes;
	}

	public OAuth2Authorization getOAuth2Authorization() {
		return _oAuth2Authorization;
	}

	private AssignableScopes _assignableScopes;
	private OAuth2Authorization _oAuth2Authorization;

}