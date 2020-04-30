/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRecentLayoutRevisionException extends NoSuchModelException {

	public NoSuchRecentLayoutRevisionException() {
	}

	public NoSuchRecentLayoutRevisionException(String msg) {
		super(msg);
	}

	public NoSuchRecentLayoutRevisionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRecentLayoutRevisionException(Throwable cause) {
		super(cause);
	}

}