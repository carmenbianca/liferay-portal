/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class AddressZipException extends PortalException {

	public AddressZipException() {
	}

	public AddressZipException(String msg) {
		super(msg);
	}

	public AddressZipException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AddressZipException(Throwable cause) {
		super(cause);
	}

}