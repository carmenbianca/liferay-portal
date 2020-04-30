/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Shinn Lok
 */
public class NoSuchServerException extends NoSuchModelException {

	public NoSuchServerException() {
	}

	public NoSuchServerException(String msg) {
		super(msg);
	}

	public NoSuchServerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchServerException(Throwable cause) {
		super(cause);
	}

}