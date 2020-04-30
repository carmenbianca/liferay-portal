/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchThreadException extends NoSuchModelException {

	public NoSuchThreadException() {
	}

	public NoSuchThreadException(String msg) {
		super(msg);
	}

	public NoSuchThreadException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchThreadException(Throwable cause) {
		super(cause);
	}

}