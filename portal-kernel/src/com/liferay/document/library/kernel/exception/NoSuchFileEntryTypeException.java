/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFileEntryTypeException extends NoSuchModelException {

	public NoSuchFileEntryTypeException() {
	}

	public NoSuchFileEntryTypeException(String msg) {
		super(msg);
	}

	public NoSuchFileEntryTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFileEntryTypeException(Throwable cause) {
		super(cause);
	}

}