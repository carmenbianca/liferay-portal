/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class RequiredCalendarException extends PortalException {

	public RequiredCalendarException() {
	}

	public RequiredCalendarException(String msg) {
		super(msg);
	}

	public RequiredCalendarException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredCalendarException(Throwable cause) {
		super(cause);
	}

}