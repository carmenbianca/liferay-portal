/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RoleNameException extends PortalException {

	public RoleNameException() {
	}

	public RoleNameException(String msg) {
		super(msg);
	}

	public RoleNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RoleNameException(Throwable cause) {
		super(cause);
	}

}