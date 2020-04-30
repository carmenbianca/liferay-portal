/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateOrganizationException extends PortalException {

	public DuplicateOrganizationException() {
	}

	public DuplicateOrganizationException(String msg) {
		super(msg);
	}

	public DuplicateOrganizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateOrganizationException(Throwable cause) {
		super(cause);
	}

}