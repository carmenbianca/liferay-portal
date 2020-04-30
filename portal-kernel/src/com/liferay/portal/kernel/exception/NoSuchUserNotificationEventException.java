/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserNotificationEventException extends NoSuchModelException {

	public NoSuchUserNotificationEventException() {
	}

	public NoSuchUserNotificationEventException(String msg) {
		super(msg);
	}

	public NoSuchUserNotificationEventException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserNotificationEventException(Throwable cause) {
		super(cause);
	}

}