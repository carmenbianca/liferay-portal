/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPasswordTrackerException extends NoSuchModelException {

	public NoSuchPasswordTrackerException() {
	}

	public NoSuchPasswordTrackerException(String msg) {
		super(msg);
	}

	public NoSuchPasswordTrackerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPasswordTrackerException(Throwable cause) {
		super(cause);
	}

}