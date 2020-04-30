/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.rest.spi.bearer.token.provider;

/**
 * @author Tomas Polesovsky
 */
public interface BearerTokenProviderAccessor {

	public BearerTokenProvider getBearerTokenProvider(
		long companyId, String clientId);

}