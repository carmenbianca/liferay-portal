/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPortletException extends NoSuchModelException {

	public NoSuchPortletException() {
	}

	public NoSuchPortletException(String msg) {
		super(msg);
	}

	public NoSuchPortletException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPortletException(Throwable cause) {
		super(cause);
	}

}