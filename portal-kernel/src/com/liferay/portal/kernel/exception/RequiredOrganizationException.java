/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredOrganizationException extends PortalException {

	public RequiredOrganizationException() {
	}

	public RequiredOrganizationException(String msg) {
		super(msg);
	}

	public RequiredOrganizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredOrganizationException(Throwable cause) {
		super(cause);
	}

}