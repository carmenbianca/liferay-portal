/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public interface WrapHttpServletRequestFilter extends DirectCallFilter {

	public HttpServletRequest getWrappedHttpServletRequest(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse);

}