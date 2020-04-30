/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class CalendarBookingStartTimeException extends PortalException {

	public CalendarBookingStartTimeException() {
	}

	public CalendarBookingStartTimeException(String msg) {
		super(msg);
	}

	public CalendarBookingStartTimeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CalendarBookingStartTimeException(Throwable cause) {
		super(cause);
	}

}