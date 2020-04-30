/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.liferay.tasks.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Ryan Park
 */
public class TasksEntryTitleException extends PortalException {

	public TasksEntryTitleException() {
	}

	public TasksEntryTitleException(String msg) {
		super(msg);
	}

	public TasksEntryTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TasksEntryTitleException(Throwable cause) {
		super(cause);
	}

}