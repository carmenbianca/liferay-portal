/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchThreadFlagException extends NoSuchModelException {

	public NoSuchThreadFlagException() {
	}

	public NoSuchThreadFlagException(String msg) {
		super(msg);
	}

	public NoSuchThreadFlagException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchThreadFlagException(Throwable cause) {
		super(cause);
	}

}