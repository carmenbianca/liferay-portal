/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lock.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLockException extends NoSuchModelException {

	public NoSuchLockException() {
	}

	public NoSuchLockException(String msg) {
		super(msg);
	}

	public NoSuchLockException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLockException(Throwable cause) {
		super(cause);
	}

}