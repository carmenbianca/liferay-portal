/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NestableException extends Exception {

	public NestableException() {
	}

	public NestableException(String msg) {
		super(msg);
	}

	public NestableException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NestableException(Throwable cause) {
		super(cause);
	}

}