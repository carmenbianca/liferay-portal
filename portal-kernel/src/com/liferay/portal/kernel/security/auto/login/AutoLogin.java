/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auto.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public interface AutoLogin {

	/**
	 * Set a request attribute with this variable to tell the AutoLoginFilter to
	 * stop processing filters and redirect the user to a specified location.
	 */
	public static final String AUTO_LOGIN_REDIRECT = "AUTO_LOGIN_REDIRECT";

	/**
	 * Set a request attribute with this variable to tell the AutoLoginFilter to
	 * continue processing filters and then redirect the user to a specified
	 * location.
	 */
	public static final String AUTO_LOGIN_REDIRECT_AND_CONTINUE =
		"AUTO_LOGIN_REDIRECT_AND_CONTINUE";

	public String[] login(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws AutoLoginException;

}