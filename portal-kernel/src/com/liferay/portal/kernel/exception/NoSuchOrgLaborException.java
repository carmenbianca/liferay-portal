/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchOrgLaborException extends NoSuchModelException {

	public NoSuchOrgLaborException() {
	}

	public NoSuchOrgLaborException(String msg) {
		super(msg);
	}

	public NoSuchOrgLaborException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchOrgLaborException(Throwable cause) {
		super(cause);
	}

}