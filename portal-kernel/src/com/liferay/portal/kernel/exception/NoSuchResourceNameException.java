/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchResourceNameException extends PortalException {

	public NoSuchResourceNameException() {
	}

	public NoSuchResourceNameException(String msg) {
		super(msg);
	}

	public NoSuchResourceNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchResourceNameException(Throwable cause) {
		super(cause);
	}

}