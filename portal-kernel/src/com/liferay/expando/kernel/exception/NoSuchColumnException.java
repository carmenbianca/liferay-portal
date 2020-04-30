/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchColumnException extends NoSuchModelException {

	public NoSuchColumnException() {
	}

	public NoSuchColumnException(String msg) {
		super(msg);
	}

	public NoSuchColumnException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchColumnException(Throwable cause) {
		super(cause);
	}

}