/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateUserGroupException extends PortalException {

	public DuplicateUserGroupException() {
	}

	public DuplicateUserGroupException(String msg) {
		super(msg);
	}

	public DuplicateUserGroupException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateUserGroupException(Throwable cause) {
		super(cause);
	}

}