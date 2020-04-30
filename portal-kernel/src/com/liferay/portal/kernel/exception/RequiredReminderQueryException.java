/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredReminderQueryException extends PortalException {

	public RequiredReminderQueryException() {
	}

	public RequiredReminderQueryException(String msg) {
		super(msg);
	}

	public RequiredReminderQueryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredReminderQueryException(Throwable cause) {
		super(cause);
	}

}