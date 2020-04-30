/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredUserGroupException extends PortalException {

	public RequiredUserGroupException() {
	}

	public RequiredUserGroupException(String msg) {
		super(msg);
	}

	public RequiredUserGroupException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredUserGroupException(Throwable cause) {
		super(cause);
	}

}