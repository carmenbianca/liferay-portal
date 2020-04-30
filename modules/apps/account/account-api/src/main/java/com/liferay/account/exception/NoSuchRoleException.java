/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRoleException extends NoSuchModelException {

	public NoSuchRoleException() {
	}

	public NoSuchRoleException(String msg) {
		super(msg);
	}

	public NoSuchRoleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRoleException(Throwable cause) {
		super(cause);
	}

}