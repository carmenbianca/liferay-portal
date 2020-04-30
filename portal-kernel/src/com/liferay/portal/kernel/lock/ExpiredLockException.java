/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.lock;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Tina Tian
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