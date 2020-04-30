/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Edward C. Han
 */
public class NoSuchActionException extends NoSuchModelException {

	public NoSuchActionException() {
	}

	public NoSuchActionException(String msg) {
		super(msg);
	}

	public NoSuchActionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchActionException(Throwable cause) {
		super(cause);
	}

}