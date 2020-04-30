/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPortletItemException extends NoSuchModelException {

	public NoSuchPortletItemException() {
	}

	public NoSuchPortletItemException(String msg) {
		super(msg);
	}

	public NoSuchPortletItemException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPortletItemException(Throwable cause) {
		super(cause);
	}

}