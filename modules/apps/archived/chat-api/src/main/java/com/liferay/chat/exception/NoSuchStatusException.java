/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchStatusException extends NoSuchModelException {

	public NoSuchStatusException() {
	}

	public NoSuchStatusException(String msg) {
		super(msg);
	}

	public NoSuchStatusException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchStatusException(Throwable cause) {
		super(cause);
	}

}