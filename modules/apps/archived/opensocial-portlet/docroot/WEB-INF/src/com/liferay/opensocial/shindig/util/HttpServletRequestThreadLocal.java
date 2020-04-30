/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.shindig.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class HttpServletRequestThreadLocal {

	public static HttpServletRequest getHttpServletRequest() {
		return _httpServletRequest.get();
	}

	public static void setHttpServletRequest(
		HttpServletRequest httpServletRequest) {

		_httpServletRequest.set(httpServletRequest);
	}

	private static final ThreadLocal<HttpServletRequest> _httpServletRequest =
		new ThreadLocal<>();

}