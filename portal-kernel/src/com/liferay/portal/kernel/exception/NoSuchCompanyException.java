/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCompanyException extends NoSuchModelException {

	public NoSuchCompanyException() {
	}

	public NoSuchCompanyException(String msg) {
		super(msg);
	}

	public NoSuchCompanyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCompanyException(Throwable cause) {
		super(cause);
	}

}