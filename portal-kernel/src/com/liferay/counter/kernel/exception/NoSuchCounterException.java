/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.counter.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCounterException extends NoSuchModelException {

	public NoSuchCounterException() {
	}

	public NoSuchCounterException(String msg) {
		super(msg);
	}

	public NoSuchCounterException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCounterException(Throwable cause) {
		super(cause);
	}

}