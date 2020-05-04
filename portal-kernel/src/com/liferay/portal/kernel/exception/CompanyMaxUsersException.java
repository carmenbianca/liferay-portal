/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class CompanyMaxUsersException extends PortalException {

	public CompanyMaxUsersException() {
	}

	public CompanyMaxUsersException(String msg) {
		super(msg);
	}

	public CompanyMaxUsersException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CompanyMaxUsersException(Throwable cause) {
		super(cause);
	}

}