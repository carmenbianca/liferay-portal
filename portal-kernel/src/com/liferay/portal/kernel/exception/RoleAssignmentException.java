/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RoleAssignmentException extends PortalException {

	public RoleAssignmentException() {
	}

	public RoleAssignmentException(String msg) {
		super(msg);
	}

	public RoleAssignmentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RoleAssignmentException(Throwable cause) {
		super(cause);
	}

}