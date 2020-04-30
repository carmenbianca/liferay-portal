/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.rest.internal.endpoint.constants;

/**
 * @author Tomas Polesovsky
 */
public class OAuth2ProviderRESTEndpointConstants {

	/**
	 * Embraces CXF OAuthConstants naming + RFC grant_type value formats.
	 */
	public static final String AUTHORIZATION_CODE_PKCE_GRANT =
		"authorization_code_pkce";

	public static final String PROPERTY_KEY_CLIENT_FEATURE_PREFIX = "feature.";

	public static final String PROPERTY_KEY_CLIENT_FEATURE_TOKEN_INTROSPECTION =
		"token_introspection";

	public static final String PROPERTY_KEY_CLIENT_FEATURES = "features";

	public static final String PROPERTY_KEY_CLIENT_REMOTE_ADDR =
		"client.remote.addr";

	public static final String PROPERTY_KEY_CLIENT_REMOTE_HOST =
		"client.remote.host";

	public static final String PROPERTY_KEY_COMPANY_ID = "company.id";

}