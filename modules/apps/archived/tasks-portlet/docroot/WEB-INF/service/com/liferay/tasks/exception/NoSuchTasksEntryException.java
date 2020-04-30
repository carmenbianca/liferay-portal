/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.liferay.tasks.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTasksEntryException extends NoSuchModelException {

	public NoSuchTasksEntryException() {
	}

	public NoSuchTasksEntryException(String msg) {
		super(msg);
	}

	public NoSuchTasksEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTasksEntryException(Throwable cause) {
		super(cause);
	}

}