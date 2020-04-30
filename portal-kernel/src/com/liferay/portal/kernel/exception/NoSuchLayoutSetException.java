/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutSetException extends NoSuchModelException {

	public NoSuchLayoutSetException() {
	}

	public NoSuchLayoutSetException(String msg) {
		super(msg);
	}

	public NoSuchLayoutSetException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutSetException(Throwable cause) {
		super(cause);
	}

}