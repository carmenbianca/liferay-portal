/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Michael Young
 */
public class CookieNotSupportedException extends PortalException {

	public CookieNotSupportedException() {
	}

	public CookieNotSupportedException(String msg) {
		super(msg);
	}

	public CookieNotSupportedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CookieNotSupportedException(Throwable cause) {
		super(cause);
	}

}