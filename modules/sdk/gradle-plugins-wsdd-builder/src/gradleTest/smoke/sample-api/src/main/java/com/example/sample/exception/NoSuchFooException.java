/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.example.sample.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFooException extends NoSuchModelException {

	public NoSuchFooException() {
	}

	public NoSuchFooException(String msg) {
		super(msg);
	}

	public NoSuchFooException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFooException(Throwable cause) {
		super(cause);
	}

}