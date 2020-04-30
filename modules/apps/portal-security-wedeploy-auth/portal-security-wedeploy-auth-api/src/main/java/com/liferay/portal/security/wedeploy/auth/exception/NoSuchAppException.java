/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Supritha Sundaram
 */
public class NoSuchAppException extends NoSuchModelException {

	public NoSuchAppException() {
	}

	public NoSuchAppException(String msg) {
		super(msg);
	}

	public NoSuchAppException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAppException(Throwable cause) {
		super(cause);
	}

}