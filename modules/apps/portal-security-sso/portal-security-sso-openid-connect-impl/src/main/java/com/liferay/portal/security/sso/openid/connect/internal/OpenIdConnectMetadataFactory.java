/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect.internal;

import com.liferay.portal.security.sso.openid.connect.OpenIdConnectServiceException;

import com.nimbusds.openid.connect.sdk.op.OIDCProviderMetadata;
import com.nimbusds.openid.connect.sdk.rp.OIDCClientMetadata;

/**
 * @author Edward C. Han
 */
public interface OpenIdConnectMetadataFactory {

	public OIDCClientMetadata getOIDCClientMetadata();

	public OIDCProviderMetadata getOIDCProviderMetadata()
		throws OpenIdConnectServiceException.ProviderException;

}