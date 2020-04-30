/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredLayoutPrototypeException extends PortalException {

	public RequiredLayoutPrototypeException() {
	}

	public RequiredLayoutPrototypeException(String msg) {
		super(msg);
	}

	public RequiredLayoutPrototypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredLayoutPrototypeException(Throwable cause) {
		super(cause);
	}

}