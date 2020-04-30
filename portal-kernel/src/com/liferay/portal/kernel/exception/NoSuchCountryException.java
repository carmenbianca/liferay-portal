/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCountryException extends NoSuchModelException {

	public NoSuchCountryException() {
	}

	public NoSuchCountryException(String msg) {
		super(msg);
	}

	public NoSuchCountryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCountryException(Throwable cause) {
		super(cause);
	}

}