/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class CompanyVirtualHostException extends PortalException {

	public CompanyVirtualHostException() {
	}

	public CompanyVirtualHostException(String msg) {
		super(msg);
	}

	public CompanyVirtualHostException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CompanyVirtualHostException(Throwable cause) {
		super(cause);
	}

}