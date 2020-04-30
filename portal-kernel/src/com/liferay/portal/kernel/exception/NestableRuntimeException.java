/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NestableRuntimeException extends RuntimeException {

	public NestableRuntimeException() {
	}

	public NestableRuntimeException(String msg) {
		super(msg);
	}

	public NestableRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NestableRuntimeException(Throwable cause) {
		super(cause);
	}

}