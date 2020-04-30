/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCompanyInfoException extends NoSuchModelException {

	public NoSuchCompanyInfoException() {
	}

	public NoSuchCompanyInfoException(String msg) {
		super(msg);
	}

	public NoSuchCompanyInfoException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCompanyInfoException(Throwable cause) {
		super(cause);
	}

}