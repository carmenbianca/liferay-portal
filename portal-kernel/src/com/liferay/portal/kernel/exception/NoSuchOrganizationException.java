/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchOrganizationException extends NoSuchModelException {

	public NoSuchOrganizationException() {
	}

	public NoSuchOrganizationException(String msg) {
		super(msg);
	}

	public NoSuchOrganizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchOrganizationException(Throwable cause) {
		super(cause);
	}

}