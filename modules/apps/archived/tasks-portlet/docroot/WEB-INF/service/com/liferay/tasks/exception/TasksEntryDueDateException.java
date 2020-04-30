/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.liferay.tasks.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class TasksEntryDueDateException extends PortalException {

	public TasksEntryDueDateException() {
	}

	public TasksEntryDueDateException(String msg) {
		super(msg);
	}

	public TasksEntryDueDateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TasksEntryDueDateException(Throwable cause) {
		super(cause);
	}

}