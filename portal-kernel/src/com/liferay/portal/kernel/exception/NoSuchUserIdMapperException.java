/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserIdMapperException extends NoSuchModelException {

	public NoSuchUserIdMapperException() {
	}

	public NoSuchUserIdMapperException(String msg) {
		super(msg);
	}

	public NoSuchUserIdMapperException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserIdMapperException(Throwable cause) {
		super(cause);
	}

}