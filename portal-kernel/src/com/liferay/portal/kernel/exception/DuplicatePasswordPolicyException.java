/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Scott Lee
 */
public class DuplicatePasswordPolicyException extends PortalException {

	public DuplicatePasswordPolicyException() {
	}

	public DuplicatePasswordPolicyException(String msg) {
		super(msg);
	}

	public DuplicatePasswordPolicyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicatePasswordPolicyException(Throwable cause) {
		super(cause);
	}

}