/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchBackgroundTaskException extends NoSuchModelException {

	public NoSuchBackgroundTaskException() {
	}

	public NoSuchBackgroundTaskException(String msg) {
		super(msg);
	}

	public NoSuchBackgroundTaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBackgroundTaskException(Throwable cause) {
		super(cause);
	}

}