/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Eduardo Lundgren
 */
public class NoSuchResourceException extends NoSuchModelException {

	public NoSuchResourceException() {
	}

	public NoSuchResourceException(String msg) {
		super(msg);
	}

	public NoSuchResourceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchResourceException(Throwable cause) {
		super(cause);
	}

}