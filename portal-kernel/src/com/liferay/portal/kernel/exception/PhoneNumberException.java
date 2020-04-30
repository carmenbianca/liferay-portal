/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class PhoneNumberException extends PortalException {

	public PhoneNumberException() {
	}

	public PhoneNumberException(String msg) {
		super(msg);
	}

	public PhoneNumberException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PhoneNumberException(Throwable cause) {
		super(cause);
	}

}