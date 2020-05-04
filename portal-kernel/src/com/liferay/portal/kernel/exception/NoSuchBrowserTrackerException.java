/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchBrowserTrackerException extends NoSuchModelException {

	public NoSuchBrowserTrackerException() {
	}

	public NoSuchBrowserTrackerException(String msg) {
		super(msg);
	}

	public NoSuchBrowserTrackerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBrowserTrackerException(Throwable cause) {
		super(cause);
	}

}