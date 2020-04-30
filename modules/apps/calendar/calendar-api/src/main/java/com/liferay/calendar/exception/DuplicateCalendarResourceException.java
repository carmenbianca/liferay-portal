/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class DuplicateCalendarResourceException extends PortalException {

	public DuplicateCalendarResourceException() {
	}

	public DuplicateCalendarResourceException(String msg) {
		super(msg);
	}

	public DuplicateCalendarResourceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateCalendarResourceException(Throwable cause) {
		super(cause);
	}

}