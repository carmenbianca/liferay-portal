/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class AccountNameException extends PortalException {

	public AccountNameException() {
	}

	public AccountNameException(String msg) {
		super(msg);
	}

	public AccountNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AccountNameException(Throwable cause) {
		super(cause);
	}

}