/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect.internal;

import com.liferay.portal.security.sso.openid.connect.OpenIdConnectProvider;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectServiceException;

import com.nimbusds.openid.connect.sdk.op.OIDCProviderMetadata;
import com.nimbusds.openid.connect.sdk.rp.OIDCClientMetadata;

/**
 * @author Thuong Dinh
 * @author Edward C. Han
 */
public class OpenIdConnectProviderImpl
	implements OpenIdConnectProvider<OIDCClientMetadata, OIDCProviderMetadata> {

	public OpenIdConnectProviderImpl(
		String name, String clientId, String clientSecret, String scopes,
		OpenIdConnectMetadataFactory openIdConnectMetadataFactory) {

		_name = name;
		_clientId = clientId;
		_clientSecret = clientSecret;
		_scopes = scopes;
		_openIdConnectMetadataFactory = openIdConnectMetadataFactory;
	}

	@Override
	public String getClientId() {
		return _clientId;
	}

	@Override
	public String getClientSecret() {
		return _clientSecret;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public OIDCClientMetadata getOIDCClientMetadata() {
		return _openIdConnectMetadataFactory.getOIDCClientMetadata();
	}

	@Override
	public OIDCProviderMetadata getOIDCProviderMetadata()
		throws OpenIdConnectServiceException.ProviderException {

		return _openIdConnectMetadataFactory.getOIDCProviderMetadata();
	}

	@Override
	public String getScopes() {
		return _scopes;
	}

	private final String _clientId;
	private final String _clientSecret;
	private final String _name;
	private final OpenIdConnectMetadataFactory _openIdConnectMetadataFactory;
	private final String _scopes;

}