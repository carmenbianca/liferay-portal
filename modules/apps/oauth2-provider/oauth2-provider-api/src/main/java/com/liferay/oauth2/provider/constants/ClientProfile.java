/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Stian Sigvartsen
 */
public enum ClientProfile {

	HEADLESS_SERVER(4, GrantType.CLIENT_CREDENTIALS),
	NATIVE_APPLICATION(
		1, GrantType.AUTHORIZATION_CODE_PKCE, GrantType.RESOURCE_OWNER_PASSWORD,
		GrantType.REFRESH_TOKEN),
	OTHER(5, GrantType.values()),
	USER_AGENT_APPLICATION(2, GrantType.AUTHORIZATION_CODE_PKCE),
	WEB_APPLICATION(
		0, GrantType.AUTHORIZATION_CODE, GrantType.CLIENT_CREDENTIALS,
		GrantType.REFRESH_TOKEN, GrantType.RESOURCE_OWNER_PASSWORD);

	public Set<GrantType> grantTypes() {
		return _grantTypes;
	}

	public int id() {
		return _id;
	}

	private ClientProfile(int id, GrantType... grantTypes) {
		_id = id;

		_grantTypes = Collections.unmodifiableSet(
			new HashSet<>(Arrays.asList(grantTypes)));
	}

	private final Set<GrantType> _grantTypes;
	private final int _id;

}