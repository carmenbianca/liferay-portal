/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserException extends NoSuchModelException {

	public NoSuchUserException() {
	}

	public NoSuchUserException(String msg) {
		super(msg);
	}

	public NoSuchUserException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserException(Throwable cause) {
		super(cause);
	}

}