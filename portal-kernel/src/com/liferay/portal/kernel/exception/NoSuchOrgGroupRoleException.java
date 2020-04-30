/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchOrgGroupRoleException extends NoSuchModelException {

	public NoSuchOrgGroupRoleException() {
	}

	public NoSuchOrgGroupRoleException(String msg) {
		super(msg);
	}

	public NoSuchOrgGroupRoleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchOrgGroupRoleException(Throwable cause) {
		super(cause);
	}

}