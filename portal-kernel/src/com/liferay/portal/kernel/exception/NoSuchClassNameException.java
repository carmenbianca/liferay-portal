/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchClassNameException extends NoSuchModelException {

	public NoSuchClassNameException() {
	}

	public NoSuchClassNameException(String msg) {
		super(msg);
	}

	public NoSuchClassNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchClassNameException(Throwable cause) {
		super(cause);
	}

}