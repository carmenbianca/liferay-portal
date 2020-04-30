/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class UserActiveException extends PortalException {

	public UserActiveException() {
	}

	public UserActiveException(String msg) {
		super(msg);
	}

	public UserActiveException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserActiveException(Throwable cause) {
		super(cause);
	}

}