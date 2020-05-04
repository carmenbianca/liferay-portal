/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.facebook.connect.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Michael C. Han
 */
@ExtendedObjectClassDefinition(category = "sso")
@Meta.OCD(
	id = "com.liferay.portal.security.sso.facebook.connect.configuration.FacebookConnectConfiguration",
	localization = "content/Language",
	name = "facebook-connect-configuration-name"
)
public interface FacebookConnectConfiguration {

	@Meta.AD(deflt = "false", name = "enabled", required = false)
	public boolean enabled();

	@Meta.AD(
		deflt = "false", name = "require-verified-account", required = false
	)
	public boolean verifiedAccountRequired();

	@Meta.AD(name = "application-id", required = false)
	public String appId();

	@Meta.AD(name = "application-secret", required = false)
	public String appSecret();

	@Meta.AD(
		deflt = "https://graph.facebook.com", name = "graph-url",
		required = false
	)
	public String graphURL();

	@Meta.AD(
		deflt = "https://graph.facebook.com/oauth/authorize",
		name = "oauth-authentication-url", required = false
	)
	public String oauthAuthURL();

	@Meta.AD(
		deflt = "https://graph.facebook.com/oauth/access_token",
		name = "oauth-token-url", required = false
	)
	public String oauthTokenURL();

	@Meta.AD(
		deflt = "http://localhost:8080/c/portal/facebook_connect_oauth",
		name = "redirect-url", required = false
	)
	public String oauthRedirectURL();

}