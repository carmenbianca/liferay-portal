/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jesse Rao
 */
@ProviderType
public interface OpenIdConnectSession {

	public String getAccessTokenValue();

	public long getLoginTime();

	public long getLoginUserId();

	public String getNonceValue();

	public OpenIdConnectFlowState getOpenIdConnectFlowState();

	public String getOpenIdProviderName();

	public String getRefreshTokenValue();

	public String getStateValue();

	public void setOpenIdConnectFlowState(
		OpenIdConnectFlowState openIdConnectFlowState);

}