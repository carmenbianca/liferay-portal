/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 * @author Zsolt Berentey
 */
public class AuthException extends PortalException {

	public static final int INTERNAL_SERVER_ERROR = 1;

	public static final int INVALID_SHARED_SECRET = 2;

	public static final int NO_SHARED_SECRET = 3;

	public AuthException() {
	}

	public AuthException(String msg) {
		super(msg);
	}

	public AuthException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AuthException(Throwable cause) {
		super(cause);
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private int _type;

}