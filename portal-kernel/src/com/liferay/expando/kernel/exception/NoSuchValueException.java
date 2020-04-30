/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchValueException extends NoSuchModelException {

	public NoSuchValueException() {
	}

	public NoSuchValueException(String msg) {
		super(msg);
	}

	public NoSuchValueException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchValueException(Throwable cause) {
		super(cause);
	}

}