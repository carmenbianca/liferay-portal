/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class CalendarResourceNameException extends PortalException {

	public CalendarResourceNameException() {
	}

	public CalendarResourceNameException(String msg) {
		super(msg);
	}

	public CalendarResourceNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CalendarResourceNameException(Throwable cause) {
		super(cause);
	}

}