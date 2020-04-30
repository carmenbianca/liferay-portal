/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMessageException extends NoSuchModelException {

	public NoSuchMessageException() {
	}

	public NoSuchMessageException(String msg) {
		super(msg);
	}

	public NoSuchMessageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchMessageException(Throwable cause) {
		super(cause);
	}

}