/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.servlet.SharedSessionServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public class SessionLayoutClone implements LayoutClone {

	@Override
	public String get(HttpServletRequest httpServletRequest, long plid) {
		HttpSession session = getPortalSession(httpServletRequest);

		return (String)session.getAttribute(encodeKey(plid));
	}

	@Override
	public void update(
		HttpServletRequest httpServletRequest, long plid, String typeSettings) {

		HttpSession session = getPortalSession(httpServletRequest);

		session.setAttribute(encodeKey(plid), typeSettings);
	}

	protected String encodeKey(long plid) {
		return SessionLayoutClone.class.getName(
		).concat(
			StringPool.POUND
		).concat(
			StringUtil.toHexString(plid)
		);
	}

	protected HttpSession getPortalSession(
		HttpServletRequest httpServletRequest) {

		HttpServletRequest originalHttpServletRequest = httpServletRequest;

		while (originalHttpServletRequest instanceof
					HttpServletRequestWrapper) {

			if (originalHttpServletRequest instanceof
					SharedSessionServletRequest) {

				SharedSessionServletRequest sharedSessionServletRequest =
					(SharedSessionServletRequest)originalHttpServletRequest;

				return sharedSessionServletRequest.getSharedSession();
			}

			HttpServletRequestWrapper httpServletRequestWrapper =
				(HttpServletRequestWrapper)originalHttpServletRequest;

			originalHttpServletRequest =
				(HttpServletRequest)httpServletRequestWrapper.getRequest();
		}

		return httpServletRequest.getSession();
	}

}