/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchProcessException extends NoSuchModelException {

	public NoSuchProcessException() {
	}

	public NoSuchProcessException(String msg) {
		super(msg);
	}

	public NoSuchProcessException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchProcessException(Throwable cause) {
		super(cause);
	}

}