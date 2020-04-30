/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutException extends NoSuchModelException {

	public NoSuchLayoutException() {
	}

	public NoSuchLayoutException(String msg) {
		super(msg);
	}

	public NoSuchLayoutException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutException(Throwable cause) {
		super(cause);
	}

}