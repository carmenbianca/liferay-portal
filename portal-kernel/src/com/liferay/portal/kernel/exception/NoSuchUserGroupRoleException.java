/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserGroupRoleException extends NoSuchModelException {

	public NoSuchUserGroupRoleException() {
	}

	public NoSuchUserGroupRoleException(String msg) {
		super(msg);
	}

	public NoSuchUserGroupRoleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserGroupRoleException(Throwable cause) {
		super(cause);
	}

}