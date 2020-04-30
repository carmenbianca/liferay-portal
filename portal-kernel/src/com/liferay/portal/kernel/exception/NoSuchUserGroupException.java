/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserGroupException extends NoSuchModelException {

	public NoSuchUserGroupException() {
	}

	public NoSuchUserGroupException(String msg) {
		super(msg);
	}

	public NoSuchUserGroupException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserGroupException(Throwable cause) {
		super(cause);
	}

}