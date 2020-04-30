/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class UserReminderQueryException extends PortalException {

	public UserReminderQueryException() {
	}

	public UserReminderQueryException(String msg) {
		super(msg);
	}

	public UserReminderQueryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserReminderQueryException(Throwable cause) {
		super(cause);
	}

}