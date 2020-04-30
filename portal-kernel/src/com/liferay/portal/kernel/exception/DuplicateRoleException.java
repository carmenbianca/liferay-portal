/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateRoleException extends PortalException {

	public DuplicateRoleException() {
	}

	public DuplicateRoleException(String msg) {
		super(msg);
	}

	public DuplicateRoleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateRoleException(Throwable cause) {
		super(cause);
	}

}