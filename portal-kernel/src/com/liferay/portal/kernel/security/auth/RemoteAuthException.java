/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

/**
 * @author Zsolt Berentey
 */
public class RemoteAuthException extends AuthException {

	public static final int WRONG_SHARED_SECRET = 101;

	public RemoteAuthException() {
	}

	public RemoteAuthException(String msg) {
		super(msg);
	}

	public RemoteAuthException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RemoteAuthException(Throwable cause) {
		super(cause);
	}

	public String getURL() {
		return _url;
	}

	public void setURL(String url) {
		_url = url;
	}

	private String _url;

}