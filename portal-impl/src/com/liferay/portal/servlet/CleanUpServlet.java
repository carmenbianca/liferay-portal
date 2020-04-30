/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet;

import com.liferay.petra.lang.CentralizedThreadLocal;

import javax.servlet.http.HttpServlet;

/**
 * @author Brian Wing Shun Chan
 */
public class CleanUpServlet extends HttpServlet {

	@Override
	public void destroy() {
		CentralizedThreadLocal.clearShortLivedThreadLocals();
	}

	@Override
	public void init() {
		CentralizedThreadLocal.clearShortLivedThreadLocals();
	}

}