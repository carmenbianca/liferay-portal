/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredCompanyException extends PortalException {

	public RequiredCompanyException() {
	}

	public RequiredCompanyException(String msg) {
		super(msg);
	}

	public RequiredCompanyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredCompanyException(Throwable cause) {
		super(cause);
	}

}