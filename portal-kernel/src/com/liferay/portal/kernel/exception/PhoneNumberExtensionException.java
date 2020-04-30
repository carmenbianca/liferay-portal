/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class PhoneNumberExtensionException extends PortalException {

	public PhoneNumberExtensionException() {
	}

	public PhoneNumberExtensionException(String msg) {
		super(msg);
	}

	public PhoneNumberExtensionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PhoneNumberExtensionException(Throwable cause) {
		super(cause);
	}

}