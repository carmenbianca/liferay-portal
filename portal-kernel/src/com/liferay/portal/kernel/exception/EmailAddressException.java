/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class EmailAddressException extends PortalException {

	public EmailAddressException() {
	}

	public EmailAddressException(String msg) {
		super(msg);
	}

	public EmailAddressException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmailAddressException(Throwable cause) {
		super(cause);
	}

}