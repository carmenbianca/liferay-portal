/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Scott Lee
 */
public class NoSuchPasswordPolicyRelException extends NoSuchModelException {

	public NoSuchPasswordPolicyRelException() {
	}

	public NoSuchPasswordPolicyRelException(String msg) {
		super(msg);
	}

	public NoSuchPasswordPolicyRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPasswordPolicyRelException(Throwable cause) {
		super(cause);
	}

}