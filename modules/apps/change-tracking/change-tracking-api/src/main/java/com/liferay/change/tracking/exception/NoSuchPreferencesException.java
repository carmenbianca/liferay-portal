/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPreferencesException extends NoSuchModelException {

	public NoSuchPreferencesException() {
	}

	public NoSuchPreferencesException(String msg) {
		super(msg);
	}

	public NoSuchPreferencesException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPreferencesException(Throwable cause) {
		super(cause);
	}

}