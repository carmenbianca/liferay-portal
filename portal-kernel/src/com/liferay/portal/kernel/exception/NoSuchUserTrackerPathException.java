/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserTrackerPathException extends NoSuchModelException {

	public NoSuchUserTrackerPathException() {
	}

	public NoSuchUserTrackerPathException(String msg) {
		super(msg);
	}

	public NoSuchUserTrackerPathException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserTrackerPathException(Throwable cause) {
		super(cause);
	}

}