/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.sessionid;

import com.liferay.portal.kernel.servlet.WrapHttpServletRequestFilter;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * http://forum.java.sun.com/thread.jspa?threadID=197150.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class SessionIdFilter
	extends BasePortalFilter implements WrapHttpServletRequestFilter {

	@Override
	public HttpServletRequest getWrappedHttpServletRequest(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		return new SessionIdServletRequest(
			httpServletRequest, httpServletResponse);
	}

}