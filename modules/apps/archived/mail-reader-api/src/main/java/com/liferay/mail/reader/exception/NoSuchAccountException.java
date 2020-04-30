/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAccountException extends NoSuchModelException {

	public NoSuchAccountException() {
	}

	public NoSuchAccountException(String msg) {
		super(msg);
	}

	public NoSuchAccountException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAccountException(Throwable cause) {
		super(cause);
	}

}