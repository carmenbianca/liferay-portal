/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFileEntryException extends NoSuchModelException {

	public NoSuchFileEntryException() {
	}

	public NoSuchFileEntryException(String msg) {
		super(msg);
	}

	public NoSuchFileEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFileEntryException(Throwable cause) {
		super(cause);
	}

}