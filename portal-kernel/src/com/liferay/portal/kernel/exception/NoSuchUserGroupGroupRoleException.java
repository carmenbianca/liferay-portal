/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserGroupGroupRoleException extends NoSuchModelException {

	public NoSuchUserGroupGroupRoleException() {
	}

	public NoSuchUserGroupGroupRoleException(String msg) {
		super(msg);
	}

	public NoSuchUserGroupGroupRoleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserGroupGroupRoleException(Throwable cause) {
		super(cause);
	}

}