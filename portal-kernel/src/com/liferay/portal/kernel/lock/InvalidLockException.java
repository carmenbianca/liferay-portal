/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.lock;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Tina Tian
 */
public class InvalidLockException extends PortalException {

	public InvalidLockException() {
	}

	public InvalidLockException(String msg) {
		super(msg);
	}

	public InvalidLockException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidLockException(Throwable cause) {
		super(cause);
	}

}