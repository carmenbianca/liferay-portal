/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Alessio Antonio Rendina
 */
public class NoSuchLogException extends NoSuchModelException {

	public NoSuchLogException() {
	}

	public NoSuchLogException(String msg) {
		super(msg);
	}

	public NoSuchLogException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLogException(Throwable cause) {
		super(cause);
	}

}