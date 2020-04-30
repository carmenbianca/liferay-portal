/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchNotificationRecipientException extends NoSuchModelException {

	public NoSuchNotificationRecipientException() {
	}

	public NoSuchNotificationRecipientException(String msg) {
		super(msg);
	}

	public NoSuchNotificationRecipientException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchNotificationRecipientException(Throwable cause) {
		super(cause);
	}

}