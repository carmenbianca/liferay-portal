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
public interface SharedSession {

	public HttpSession getSharedSessionWrapper(
		HttpSession portalSession, HttpServletRequest httpServletRequest);

}