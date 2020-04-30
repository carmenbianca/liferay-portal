/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchNotFoundEntryException extends NoSuchModelException {

	public NoSuchNotFoundEntryException() {
	}

	public NoSuchNotFoundEntryException(String msg) {
		super(msg);
	}

	public NoSuchNotFoundEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchNotFoundEntryException(Throwable cause) {
		super(cause);
	}

}