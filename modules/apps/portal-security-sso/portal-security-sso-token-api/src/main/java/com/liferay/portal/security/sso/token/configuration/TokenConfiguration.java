/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.token.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.security.sso.token.security.auth.TokenLocation;

/**
 * @author Michael C. Han
 * @author Mika Koivisto
 */
@ExtendedObjectClassDefinition(category = "sso")
@Meta.OCD(
	id = "com.liferay.portal.security.sso.token.configuration.TokenConfiguration",
	localization = "content/Language", name = "token-configuration-name"
)
public interface TokenConfiguration {

	@Meta.AD(deflt = "false", name = "enabled", required = false)
	public boolean enabled();

	@Meta.AD(
		deflt = "false", description = "import-from-ldap-help",
		name = "import-from-ldap", required = false
	)
	public boolean importFromLDAP();

	@Meta.AD(
		deflt = "SM_USER", description = "user-token-name-help",
		name = "user-token-name", required = false
	)
	public String userTokenName();

	@Meta.AD(
		deflt = "REQUEST_HEADER", description = "token-location-help",
		name = "token-location",
		optionLabels = {
			"token-location-" + TokenLocation.COOKIE,
			"token-location-" + TokenLocation.REQUEST,
			"token-location-" + TokenLocation.REQUEST_HEADER,
			"token-location-" + TokenLocation.SESSION
		},
		optionValues = {
			TokenLocation.COOKIE, TokenLocation.REQUEST,
			TokenLocation.REQUEST_HEADER, TokenLocation.SESSION
		},
		required = false
	)
	public String tokenLocation();

	@Meta.AD(
		deflt = "SMIDENTITY|SMSESSION",
		description = "authentication-cookies-help",
		name = "authentication-cookies", required = false
	)
	public String[] authenticationCookies();

	@Meta.AD(name = "logout-redirect-url", required = false)
	public String logoutRedirectURL();

}