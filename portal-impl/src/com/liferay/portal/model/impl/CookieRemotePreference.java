/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.RemotePreference;

import javax.servlet.http.Cookie;

/**
 * @author Carlos Sierra Andrés
 */
public class CookieRemotePreference implements RemotePreference {

	public CookieRemotePreference(Cookie cookie) {
		_cookie = cookie;

		String cookieName = cookie.getName();

		_name = cookieName.substring(
			CookieKeys.REMOTE_PREFERENCE_PREFIX.length());
	}

	public Cookie getCookie() {
		return _cookie;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getValue() {
		return _cookie.getValue();
	}

	private final Cookie _cookie;
	private final String _name;

}