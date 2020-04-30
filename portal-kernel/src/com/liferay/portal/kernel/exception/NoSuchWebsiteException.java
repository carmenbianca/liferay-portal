/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchWebsiteException extends NoSuchModelException {

	public NoSuchWebsiteException() {
	}

	public NoSuchWebsiteException(String msg) {
		super(msg);
	}

	public NoSuchWebsiteException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchWebsiteException(Throwable cause) {
		super(cause);
	}

}