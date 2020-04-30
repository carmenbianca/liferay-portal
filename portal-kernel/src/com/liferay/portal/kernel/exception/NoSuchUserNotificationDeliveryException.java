/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserNotificationDeliveryException
	extends NoSuchModelException {

	public NoSuchUserNotificationDeliveryException() {
	}

	public NoSuchUserNotificationDeliveryException(String msg) {
		super(msg);
	}

	public NoSuchUserNotificationDeliveryException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public NoSuchUserNotificationDeliveryException(Throwable cause) {
		super(cause);
	}

}