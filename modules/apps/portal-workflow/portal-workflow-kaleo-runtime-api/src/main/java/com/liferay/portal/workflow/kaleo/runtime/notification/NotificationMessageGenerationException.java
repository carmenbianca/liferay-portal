/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.notification;

import com.liferay.portal.kernel.workflow.WorkflowException;

/**
 * @author Michael C. Han
 */
public class NotificationMessageGenerationException extends WorkflowException {

	public NotificationMessageGenerationException() {
	}

	public NotificationMessageGenerationException(String msg) {
		super(msg);
	}

	public NotificationMessageGenerationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NotificationMessageGenerationException(Throwable cause) {
		super(cause);
	}

}