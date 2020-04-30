/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import com.liferay.petra.lang.CentralizedThreadLocal;

import javax.servlet.http.HttpSession;

/**
 * @author Shuyang Zhou
 */
public class PortalSessionThreadLocal {

	public static HttpSession getHttpSession() {
		String sessionId = _sessionId.get();

		if (sessionId == null) {
			return null;
		}

		return PortalSessionContext.get(sessionId);
	}

	public static void setHttpSession(HttpSession session) {
		_sessionId.set(session.getId());
	}

	private static final ThreadLocal<String> _sessionId =
		new CentralizedThreadLocal<>(
			PortalSessionThreadLocal.class + "._sessionId");

}