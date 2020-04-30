/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class CalendarNameException extends PortalException {

	public CalendarNameException() {
	}

	public CalendarNameException(String msg) {
		super(msg);
	}

	public CalendarNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CalendarNameException(Throwable cause) {
		super(cause);
	}

}