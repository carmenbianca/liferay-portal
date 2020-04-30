/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class ContactClassNameException extends PortalException {

	public ContactClassNameException() {
	}

	public ContactClassNameException(String msg) {
		super(msg);
	}

	public ContactClassNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ContactClassNameException(Throwable cause) {
		super(cause);
	}

}