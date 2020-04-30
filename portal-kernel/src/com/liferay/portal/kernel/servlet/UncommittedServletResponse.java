/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author Brian Wing Shun Chan
 */
public class UncommittedServletResponse extends HttpServletResponseWrapper {

	public UncommittedServletResponse(HttpServletResponse httpServletResponse) {
		super(httpServletResponse);
	}

	@Override
	public boolean isCommitted() {
		return _COMMITTED;
	}

	private static final boolean _COMMITTED = false;

}