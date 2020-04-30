/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Scott Lee
 */
public class PasswordPolicyNameException extends PortalException {

	public PasswordPolicyNameException() {
	}

	public PasswordPolicyNameException(String msg) {
		super(msg);
	}

	public PasswordPolicyNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PasswordPolicyNameException(Throwable cause) {
		super(cause);
	}

}