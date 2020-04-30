/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 * @author Brian Myunghun Kim
 */
public class SharedSessionServletRequest extends HttpServletRequestWrapper {

	public SharedSessionServletRequest(
		HttpServletRequest httpServletRequest, boolean shared) {

		super(httpServletRequest);

		_portalSession = httpServletRequest.getSession();
		_shared = shared;
	}

	@Override
	public HttpSession getSession() {
		return getSession(true);
	}

	@Override
	public HttpSession getSession(boolean create) {
		if (create) {
			checkPortalSession();
		}

		if (_shared) {
			return _portalSession;
		}

		HttpSession portletSession = super.getSession(create);

		if ((portletSession != null) && (portletSession != _portalSession)) {
			return getSharedSessionWrapper(_portalSession, portletSession);
		}

		return portletSession;
	}

	public HttpSession getSharedSession() {
		return _portalSession;
	}

	protected void checkPortalSession() {
		try {
			_portalSession.isNew();
		}
		catch (IllegalStateException illegalStateException) {
			_portalSession = super.getSession(true);
		}
	}

	protected HttpSession getSharedSessionWrapper(
		HttpSession portalSession, HttpSession portletSession) {

		return new SharedSessionWrapper(portalSession, portletSession);
	}

	private HttpSession _portalSession;
	private final boolean _shared;

}