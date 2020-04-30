/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutSetPrototypeException extends NoSuchModelException {

	public NoSuchLayoutSetPrototypeException() {
	}

	public NoSuchLayoutSetPrototypeException(String msg) {
		super(msg);
	}

	public NoSuchLayoutSetPrototypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutSetPrototypeException(Throwable cause) {
		super(cause);
	}

}