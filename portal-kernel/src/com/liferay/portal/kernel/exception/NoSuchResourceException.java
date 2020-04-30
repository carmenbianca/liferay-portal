/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
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