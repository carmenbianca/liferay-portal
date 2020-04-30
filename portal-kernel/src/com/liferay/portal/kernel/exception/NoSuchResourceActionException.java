/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchResourceActionException extends NoSuchModelException {

	public NoSuchResourceActionException() {
	}

	public NoSuchResourceActionException(String msg) {
		super(msg);
	}

	public NoSuchResourceActionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchResourceActionException(Throwable cause) {
		super(cause);
	}

}