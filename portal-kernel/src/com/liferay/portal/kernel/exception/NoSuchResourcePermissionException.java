/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchResourcePermissionException extends NoSuchModelException {

	public NoSuchResourcePermissionException() {
	}

	public NoSuchResourcePermissionException(String msg) {
		super(msg);
	}

	public NoSuchResourcePermissionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchResourcePermissionException(Throwable cause) {
		super(cause);
	}

}