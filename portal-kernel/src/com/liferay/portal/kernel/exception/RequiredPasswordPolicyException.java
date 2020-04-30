/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredPasswordPolicyException extends PortalException {

	public RequiredPasswordPolicyException() {
	}

	public RequiredPasswordPolicyException(String msg) {
		super(msg);
	}

	public RequiredPasswordPolicyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredPasswordPolicyException(Throwable cause) {
		super(cause);
	}

}