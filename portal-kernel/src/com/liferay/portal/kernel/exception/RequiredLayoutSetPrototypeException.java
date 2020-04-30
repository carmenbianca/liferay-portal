/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredLayoutSetPrototypeException extends PortalException {

	public RequiredLayoutSetPrototypeException() {
	}

	public RequiredLayoutSetPrototypeException(String msg) {
		super(msg);
	}

	public RequiredLayoutSetPrototypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredLayoutSetPrototypeException(Throwable cause) {
		super(cause);
	}

}