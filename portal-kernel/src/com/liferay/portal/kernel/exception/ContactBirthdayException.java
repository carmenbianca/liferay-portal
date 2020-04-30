/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class ContactBirthdayException extends PortalException {

	public ContactBirthdayException() {
	}

	public ContactBirthdayException(String msg) {
		super(msg);
	}

	public ContactBirthdayException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ContactBirthdayException(Throwable cause) {
		super(cause);
	}

}