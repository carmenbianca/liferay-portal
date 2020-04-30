/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Eduardo Lundgren
 */
public class NoSuchBookingException extends NoSuchModelException {

	public NoSuchBookingException() {
	}

	public NoSuchBookingException(String msg) {
		super(msg);
	}

	public NoSuchBookingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBookingException(Throwable cause) {
		super(cause);
	}

}