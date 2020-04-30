/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class AddressStreetException extends PortalException {

	public AddressStreetException() {
	}

	public AddressStreetException(String msg) {
		super(msg);
	}

	public AddressStreetException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AddressStreetException(Throwable cause) {
		super(cause);
	}

}