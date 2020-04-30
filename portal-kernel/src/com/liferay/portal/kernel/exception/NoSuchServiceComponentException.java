/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchServiceComponentException extends NoSuchModelException {

	public NoSuchServiceComponentException() {
	}

	public NoSuchServiceComponentException(String msg) {
		super(msg);
	}

	public NoSuchServiceComponentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchServiceComponentException(Throwable cause) {
		super(cause);
	}

}