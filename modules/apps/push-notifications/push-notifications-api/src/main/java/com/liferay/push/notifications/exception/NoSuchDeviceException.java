/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Bruno Farache
 */
public class NoSuchDeviceException extends NoSuchModelException {

	public NoSuchDeviceException() {
	}

	public NoSuchDeviceException(String msg) {
		super(msg);
	}

	public NoSuchDeviceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchDeviceException(Throwable cause) {
		super(cause);
	}

}