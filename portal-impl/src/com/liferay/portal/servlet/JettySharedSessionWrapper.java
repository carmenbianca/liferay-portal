/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet;

import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.session.AbstractSession;
import org.eclipse.jetty.server.session.AbstractSessionManager;

/**
 * @author     Brian Wing Shun Chan
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class JettySharedSessionWrapper
	extends SharedSessionWrapper implements AbstractSessionManager.SessionIf {

	public JettySharedSessionWrapper(
		HttpSession portalSession, HttpSession portletSession) {

		super(portalSession, portletSession);
	}

	@Override
	public AbstractSession getSession() {
		return (AbstractSession)getSessionDelegate();
	}

}