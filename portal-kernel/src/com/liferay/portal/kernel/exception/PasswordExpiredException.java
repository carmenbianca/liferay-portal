/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class PasswordExpiredException extends PortalException {

	public PasswordExpiredException() {
	}

	public PasswordExpiredException(String msg) {
		super(msg);
	}

	public PasswordExpiredException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PasswordExpiredException(Throwable cause) {
		super(cause);
	}

}