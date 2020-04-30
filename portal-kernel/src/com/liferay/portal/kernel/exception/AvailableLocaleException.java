/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class AvailableLocaleException extends PortalException {

	public AvailableLocaleException() {
	}

	public AvailableLocaleException(String msg) {
		super(msg);
	}

	public AvailableLocaleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AvailableLocaleException(Throwable cause) {
		super(cause);
	}

}