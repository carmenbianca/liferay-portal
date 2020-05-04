/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRowException extends NoSuchModelException {

	public NoSuchRowException() {
	}

	public NoSuchRowException(String msg) {
		super(msg);
	}

	public NoSuchRowException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRowException(Throwable cause) {
		super(cause);
	}

}