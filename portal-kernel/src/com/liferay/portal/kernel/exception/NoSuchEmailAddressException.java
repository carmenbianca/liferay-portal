/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEmailAddressException extends NoSuchModelException {

	public NoSuchEmailAddressException() {
	}

	public NoSuchEmailAddressException(String msg) {
		super(msg);
	}

	public NoSuchEmailAddressException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEmailAddressException(Throwable cause) {
		super(cause);
	}

}