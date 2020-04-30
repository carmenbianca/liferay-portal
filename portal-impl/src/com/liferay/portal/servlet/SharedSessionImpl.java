/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.servlet.SharedSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Raymond Augé
 */
public class SharedSessionImpl implements SharedSession {

	@Override
	public HttpSession getSharedSessionWrapper(
		HttpSession portalSession, HttpServletRequest httpServletRequest) {

		HttpSession portletSession = httpServletRequest.getSession();

		return new SharedSessionWrapper(portalSession, portletSession);
	}

}