/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Thuong Dinh
 */
@ProviderType
public interface OpenIdConnectProviderRegistry<S, T> {

	public OpenIdConnectProvider<S, T> findOpenIdConnectProvider(String name)
		throws OpenIdConnectServiceException.ProviderException;

	public OpenIdConnectProvider<S, T> getOpenIdConnectProvider(String name);

	public Collection<String> getOpenIdConnectProviderNames();

}