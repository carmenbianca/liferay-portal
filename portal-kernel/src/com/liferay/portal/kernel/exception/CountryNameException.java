/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class CountryNameException extends PortalException {

	public CountryNameException() {
	}

	public CountryNameException(String msg) {
		super(msg);
	}

	public CountryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CountryNameException(Throwable cause) {
		super(cause);
	}

}