/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchActivityCounterException extends NoSuchModelException {

	public NoSuchActivityCounterException() {
	}

	public NoSuchActivityCounterException(String msg) {
		super(msg);
	}

	public NoSuchActivityCounterException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchActivityCounterException(Throwable cause) {
		super(cause);
	}

}