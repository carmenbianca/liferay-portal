/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.web.internal.display.context;

import com.liferay.document.library.util.DLURLHelper;
import com.liferay.oauth2.provider.constants.OAuth2ProviderActionKeys;
import com.liferay.oauth2.provider.model.OAuth2Application;
import com.liferay.oauth2.provider.web.internal.AssignableScopes;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tomas Polesovsky
 */
public class OAuth2AuthorizePortletDisplayContext
	extends BaseOAuth2PortletDisplayContext {

	public OAuth2AuthorizePortletDisplayContext(
		ThemeDisplay themeDisplay, DLURLHelper dlURLHelper) {

		super.themeDisplay = themeDisplay;
		super.dlURLHelper = dlURLHelper;
	}

	public AssignableScopes getAssignableScopes() {
		return _assignableScopes;
	}

	@Override
	public OAuth2Application getOAuth2Application() {
		return _oAuth2Application;
	}

	public Map<String, String> getOAuth2Parameters() {
		return _oAuth2Parameters;
	}

	public boolean hasCreateTokenApplicationPermission(
		OAuth2Application oAuth2Application) {

		return hasPermission(
			oAuth2Application, OAuth2ProviderActionKeys.ACTION_CREATE_TOKEN);
	}

	public void setAssignableScopes(AssignableScopes assignableScopes) {
		_assignableScopes = assignableScopes;
	}

	public void setOAuth2Application(OAuth2Application oAuth2Application) {
		_oAuth2Application = oAuth2Application;
	}

	public void setOAuth2Parameters(Map<String, String> oAuth2Parameters) {
		_oAuth2Parameters = oAuth2Parameters;
	}

	private AssignableScopes _assignableScopes;
	private OAuth2Application _oAuth2Application;
	private Map<String, String> _oAuth2Parameters = new HashMap<>();

}