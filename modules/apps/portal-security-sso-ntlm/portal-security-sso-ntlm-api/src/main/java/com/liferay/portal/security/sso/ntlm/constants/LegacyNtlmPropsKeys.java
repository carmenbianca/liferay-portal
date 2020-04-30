/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.ntlm.constants;

/**
 * @author Brian Greenwald
 */
public class LegacyNtlmPropsKeys {

	public static final String NTLM_AUTH_DOMAIN = "ntlm.auth.domain";

	public static final String NTLM_AUTH_DOMAIN_CONTROLLER =
		"ntlm.auth.domain.controller";

	public static final String NTLM_AUTH_DOMAIN_CONTROLLER_NAME =
		"ntlm.auth.domain.controller.name";

	public static final String NTLM_AUTH_ENABLED = "ntlm.auth.enabled";

	public static final String[] NTLM_AUTH_KEYS = {
		NTLM_AUTH_DOMAIN, NTLM_AUTH_DOMAIN_CONTROLLER,
		NTLM_AUTH_DOMAIN_CONTROLLER_NAME, NTLM_AUTH_ENABLED,
		LegacyNtlmPropsKeys.NTLM_AUTH_NEGOTIATE_FLAGS,
		LegacyNtlmPropsKeys.NTLM_AUTH_SERVICE_ACCOUNT,
		LegacyNtlmPropsKeys.NTLM_AUTH_SERVICE_PASSWORD
	};

	public static final String NTLM_AUTH_NEGOTIATE_FLAGS =
		"ntlm.auth.negotiate.flags";

	public static final String NTLM_AUTH_SERVICE_ACCOUNT =
		"ntlm.auth.service.account";

	public static final String NTLM_AUTH_SERVICE_PASSWORD =
		"ntlm.auth.service.password";

}