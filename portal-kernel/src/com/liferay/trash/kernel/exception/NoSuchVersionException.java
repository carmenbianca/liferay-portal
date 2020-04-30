/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchVersionException extends NoSuchModelException {

	public NoSuchVersionException() {
	}

	public NoSuchVersionException(String msg) {
		super(msg);
	}

	public NoSuchVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchVersionException(Throwable cause) {
		super(cause);
	}

}