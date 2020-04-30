/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPortletPreferencesException extends NoSuchModelException {

	public NoSuchPortletPreferencesException() {
	}

	public NoSuchPortletPreferencesException(String msg) {
		super(msg);
	}

	public NoSuchPortletPreferencesException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPortletPreferencesException(Throwable cause) {
		super(cause);
	}

}