/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSystemEventException extends NoSuchModelException {

	public NoSuchSystemEventException() {
	}

	public NoSuchSystemEventException(String msg) {
		super(msg);
	}

	public NoSuchSystemEventException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSystemEventException(Throwable cause) {
		super(cause);
	}

}