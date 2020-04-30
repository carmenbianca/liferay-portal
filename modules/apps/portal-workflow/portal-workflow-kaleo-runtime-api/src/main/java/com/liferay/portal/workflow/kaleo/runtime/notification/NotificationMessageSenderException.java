/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.notification;

import com.liferay.portal.kernel.workflow.WorkflowException;

/**
 * @author Michael C. Han
 */
public class NotificationMessageSenderException extends WorkflowException {

	public NotificationMessageSenderException() {
	}

	public NotificationMessageSenderException(String msg) {
		super(msg);
	}

	public NotificationMessageSenderException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NotificationMessageSenderException(Throwable cause) {
		super(cause);
	}

}