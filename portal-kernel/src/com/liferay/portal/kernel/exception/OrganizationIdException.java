/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationIdException extends PortalException {

	public OrganizationIdException() {
	}

	public OrganizationIdException(String msg) {
		super(msg);
	}

	public OrganizationIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OrganizationIdException(Throwable cause) {
		super(cause);
	}

}