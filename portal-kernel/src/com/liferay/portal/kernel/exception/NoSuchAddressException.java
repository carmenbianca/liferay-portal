/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAddressException extends NoSuchModelException {

	public NoSuchAddressException() {
	}

	public NoSuchAddressException(String msg) {
		super(msg);
	}

	public NoSuchAddressException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAddressException(Throwable cause) {
		super(cause);
	}

}