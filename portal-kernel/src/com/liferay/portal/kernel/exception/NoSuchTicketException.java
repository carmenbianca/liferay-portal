/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTicketException extends NoSuchModelException {

	public NoSuchTicketException() {
	}

	public NoSuchTicketException(String msg) {
		super(msg);
	}

	public NoSuchTicketException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTicketException(Throwable cause) {
		super(cause);
	}

}