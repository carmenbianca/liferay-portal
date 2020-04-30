/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Raymond Augé
 */
public class SharedSessionUtil {

	public static HttpSession getSharedSessionWrapper(
		HttpSession portalSession, HttpServletRequest httpServletRequest) {

		return _sharedSession.getSharedSessionWrapper(
			portalSession, httpServletRequest);
	}

	public void setSharedSession(SharedSession sharedSession) {
		_sharedSession = sharedSession;
	}

	private static SharedSession _sharedSession;

}