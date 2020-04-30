/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationNameException extends PortalException {

	public OrganizationNameException() {
	}

	public OrganizationNameException(String msg) {
		super(msg);
	}

	public OrganizationNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OrganizationNameException(Throwable cause) {
		super(cause);
	}

}