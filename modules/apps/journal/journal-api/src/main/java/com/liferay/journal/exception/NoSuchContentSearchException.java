/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchContentSearchException extends NoSuchModelException {

	public NoSuchContentSearchException() {
	}

	public NoSuchContentSearchException(String msg) {
		super(msg);
	}

	public NoSuchContentSearchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchContentSearchException(Throwable cause) {
		super(cause);
	}

}