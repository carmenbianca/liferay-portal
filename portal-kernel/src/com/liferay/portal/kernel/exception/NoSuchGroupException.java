/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchGroupException extends NoSuchModelException {

	public NoSuchGroupException() {
	}

	public NoSuchGroupException(String msg) {
		super(msg);
	}

	public NoSuchGroupException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchGroupException(Throwable cause) {
		super(cause);
	}

}