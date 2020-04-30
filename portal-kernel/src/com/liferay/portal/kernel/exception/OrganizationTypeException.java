/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationTypeException extends PortalException {

	public OrganizationTypeException() {
	}

	public OrganizationTypeException(String msg) {
		super(msg);
	}

	public OrganizationTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OrganizationTypeException(Throwable cause) {
		super(cause);
	}

}