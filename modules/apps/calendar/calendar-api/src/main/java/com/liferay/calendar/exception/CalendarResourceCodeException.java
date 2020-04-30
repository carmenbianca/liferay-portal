/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class CalendarResourceCodeException extends PortalException {

	public CalendarResourceCodeException() {
	}

	public CalendarResourceCodeException(String msg) {
		super(msg);
	}

	public CalendarResourceCodeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CalendarResourceCodeException(Throwable cause) {
		super(cause);
	}

}