/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.notification;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class NotificationSenderException extends PortalException {

	public NotificationSenderException() {
	}

	public NotificationSenderException(String msg) {
		super(msg);
	}

	public NotificationSenderException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NotificationSenderException(Throwable cause) {
		super(cause);
	}

}