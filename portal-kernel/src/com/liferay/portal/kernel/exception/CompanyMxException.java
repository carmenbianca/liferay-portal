/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class CompanyMxException extends PortalException {

	public CompanyMxException() {
	}

	public CompanyMxException(String msg) {
		super(msg);
	}

	public CompanyMxException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CompanyMxException(Throwable cause) {
		super(cause);
	}

}