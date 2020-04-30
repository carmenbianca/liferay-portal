/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.webdav;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alexander Chow
 */
public class LockException extends PortalException {

	public LockException() {
	}

	public LockException(String msg) {
		super(msg);
	}

	public LockException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LockException(Throwable cause) {
		super(cause);
	}

}