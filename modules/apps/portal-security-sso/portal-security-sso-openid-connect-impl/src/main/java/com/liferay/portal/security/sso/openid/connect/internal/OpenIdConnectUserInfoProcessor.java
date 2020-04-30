/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect.internal;

import com.liferay.portal.kernel.exception.PortalException;

import com.nimbusds.openid.connect.sdk.claims.UserInfo;

/**
 * @author Michael C. Han
 */
public interface OpenIdConnectUserInfoProcessor {

	public long processUserInfo(UserInfo userInfo, long companyId)
		throws PortalException;

}