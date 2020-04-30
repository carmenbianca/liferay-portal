/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lock.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ExpiredLockException extends PortalException {

	public ExpiredLockException() {
	}

	public ExpiredLockException(String msg) {
		super(msg);
	}

	public ExpiredLockException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ExpiredLockException(Throwable cause) {
		super(cause);
	}

}