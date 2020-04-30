/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid;

import java.net.URL;

import java.util.Collection;

/**
 * @author Michael C. Han
 */
public interface OpenIdProviderRegistry {

	public static final String OPEN_ID_PROVIDER_NAME_DEFAULT = "default";

	public OpenIdProvider getOpenIdProvider(String name);

	public OpenIdProvider getOpenIdProvider(URL url);

	public Collection<String> getOpenIdProviderNames();

}