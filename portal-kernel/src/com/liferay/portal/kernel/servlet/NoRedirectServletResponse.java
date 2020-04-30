/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author Peter Shin
 * @author Brian Wing Shun Chan
 */
public class NoRedirectServletResponse extends HttpServletResponseWrapper {

	public NoRedirectServletResponse(HttpServletResponse httpServletResponse) {
		super(httpServletResponse);
	}

	public String getRedirectLocation() {
		return _redirectLocation;
	}

	@Override
	public void sendRedirect(String location) {

		// Disable send redirect

		_redirectLocation = location;
	}

	private String _redirectLocation;

}