/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Eduardo Lundgren
 */
public class NoSuchCalendarException extends NoSuchModelException {

	public NoSuchCalendarException() {
	}

	public NoSuchCalendarException(String msg) {
		super(msg);
	}

	public NoSuchCalendarException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCalendarException(Throwable cause) {
		super(cause);
	}

}