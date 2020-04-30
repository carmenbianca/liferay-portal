/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class UserGroupNameException extends PortalException {

	public UserGroupNameException() {
	}

	public UserGroupNameException(String msg) {
		super(msg);
	}

	public UserGroupNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserGroupNameException(Throwable cause) {
		super(cause);
	}

}