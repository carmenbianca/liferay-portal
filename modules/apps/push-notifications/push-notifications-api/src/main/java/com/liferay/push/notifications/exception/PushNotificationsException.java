/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Bruno Farache
 */
public class PushNotificationsException extends PortalException {

	public PushNotificationsException() {
	}

	public PushNotificationsException(String msg) {
		super(msg);
	}

	public PushNotificationsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PushNotificationsException(Throwable cause) {
		super(cause);
	}

}