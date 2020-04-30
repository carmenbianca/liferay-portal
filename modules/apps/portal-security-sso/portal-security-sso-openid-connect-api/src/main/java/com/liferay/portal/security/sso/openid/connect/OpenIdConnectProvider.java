/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface OpenIdConnectProvider<S, T> {

	public String getClientId();

	public String getClientSecret();

	public String getName();

	public S getOIDCClientMetadata();

	public T getOIDCProviderMetadata()
		throws OpenIdConnectServiceException.ProviderException;

	public String getScopes();

}