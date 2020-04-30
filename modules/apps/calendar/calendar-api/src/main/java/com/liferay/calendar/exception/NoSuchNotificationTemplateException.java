/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Eduardo Lundgren
 */
public class NoSuchNotificationTemplateException extends NoSuchModelException {

	public NoSuchNotificationTemplateException() {
	}

	public NoSuchNotificationTemplateException(String msg) {
		super(msg);
	}

	public NoSuchNotificationTemplateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchNotificationTemplateException(Throwable cause) {
		super(cause);
	}

}