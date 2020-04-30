/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth.tunnel;

import com.liferay.portal.kernel.security.auth.AuthException;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tomas Polesovsky
 */
public interface TunnelAuthenticationManager {

	public long getUserId(HttpServletRequest httpServletRequest)
		throws AuthException;

	public void setCredentials(
			String login, HttpURLConnection httpURLConnection)
		throws Exception;

}