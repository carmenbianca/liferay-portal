/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth.http;

import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tomas Polesovsky
 */
public interface HttpAuthManager {

	public void generateChallenge(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse,
		HttpAuthorizationHeader httpAuthorizationHeader);

	public long getBasicUserId(HttpServletRequest httpServletRequest)
		throws PortalException;

	public long getDigestUserId(HttpServletRequest httpServletRequest)
		throws PortalException;

	public long getUserId(
			HttpServletRequest httpServletRequest,
			HttpAuthorizationHeader httpAuthorizationHeader)
		throws PortalException;

	public HttpAuthorizationHeader parse(HttpServletRequest httpServletRequest);

}