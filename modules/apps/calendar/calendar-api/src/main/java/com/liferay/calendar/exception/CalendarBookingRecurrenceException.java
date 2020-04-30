/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class CalendarBookingRecurrenceException extends PortalException {

	public CalendarBookingRecurrenceException() {
	}

	public CalendarBookingRecurrenceException(String msg) {
		super(msg);
	}

	public CalendarBookingRecurrenceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CalendarBookingRecurrenceException(Throwable cause) {
		super(cause);
	}

}