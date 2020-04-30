/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutRevisionException extends NoSuchModelException {

	public NoSuchLayoutRevisionException() {
	}

	public NoSuchLayoutRevisionException(String msg) {
		super(msg);
	}

	public NoSuchLayoutRevisionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutRevisionException(Throwable cause) {
		super(cause);
	}

}