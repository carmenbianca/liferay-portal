/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Eduardo García
 */
public class NoSuchEntryRelException extends NoSuchModelException {

	public NoSuchEntryRelException() {
	}

	public NoSuchEntryRelException(String msg) {
		super(msg);
	}

	public NoSuchEntryRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntryRelException(Throwable cause) {
		super(cause);
	}

}