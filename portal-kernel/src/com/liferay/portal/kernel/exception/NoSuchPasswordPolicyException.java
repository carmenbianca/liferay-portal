/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Scott Lee
 */
public class NoSuchPasswordPolicyException extends NoSuchModelException {

	public NoSuchPasswordPolicyException() {
	}

	public NoSuchPasswordPolicyException(String msg) {
		super(msg);
	}

	public NoSuchPasswordPolicyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPasswordPolicyException(Throwable cause) {
		super(cause);
	}

}