/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.token.constants;

/**
 * @author Brian Greenwald
 */
public class LegacyTokenPropsKeys {

	public static final String SHIBBOLETH_AUTH_ENABLED =
		"shibboleth.auth.enabled";

	public static final String SHIBBOLETH_IMPORT_FROM_LDAP =
		"shibboleth.import.from.ldap";

	public static final String[] SHIBBOLETH_KEYS = {
		SHIBBOLETH_AUTH_ENABLED, SHIBBOLETH_IMPORT_FROM_LDAP,
		LegacyTokenPropsKeys.SHIBBOLETH_LOGOUT_URL,
		LegacyTokenPropsKeys.SHIBBOLETH_USER_HEADER
	};

	public static final String SHIBBOLETH_LOGOUT_URL = "shibboleth.logout.url";

	public static final String SHIBBOLETH_USER_HEADER =
		"shibboleth.user.header";

	public static final String SITEMINDER_AUTH_ENABLED =
		"siteminder.auth.enabled";

	public static final String SITEMINDER_IMPORT_FROM_LDAP =
		"siteminder.import.from.ldap";

	public static final String[] SITEMINDER_KEYS = {
		SITEMINDER_AUTH_ENABLED, SITEMINDER_IMPORT_FROM_LDAP,
		LegacyTokenPropsKeys.SITEMINDER_USER_HEADER
	};

	public static final String SITEMINDER_USER_HEADER =
		"siteminder.user.header";

}