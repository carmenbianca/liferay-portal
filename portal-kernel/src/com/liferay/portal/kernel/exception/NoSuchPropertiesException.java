/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPropertiesException extends PortalException {

	public NoSuchPropertiesException() {
	}

	public NoSuchPropertiesException(String msg) {
		super(msg);
	}

	public NoSuchPropertiesException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPropertiesException(Throwable cause) {
		super(cause);
	}

}