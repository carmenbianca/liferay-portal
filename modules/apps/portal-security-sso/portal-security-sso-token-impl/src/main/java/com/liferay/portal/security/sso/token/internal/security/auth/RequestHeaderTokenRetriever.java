/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.token.internal.security.auth;

import com.liferay.portal.security.sso.token.security.auth.TokenLocation;
import com.liferay.portal.security.sso.token.security.auth.TokenRetriever;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	property = "token.location=" + TokenLocation.REQUEST_HEADER,
	service = TokenRetriever.class
)
public class RequestHeaderTokenRetriever implements TokenRetriever {

	@Override
	public String getLoginToken(
		HttpServletRequest httpServletRequest, String userTokenName) {

		return httpServletRequest.getHeader(userTokenName);
	}

}