/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutPrototypeException extends NoSuchModelException {

	public NoSuchLayoutPrototypeException() {
	}

	public NoSuchLayoutPrototypeException(String msg) {
		super(msg);
	}

	public NoSuchLayoutPrototypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutPrototypeException(Throwable cause) {
		super(cause);
	}

}