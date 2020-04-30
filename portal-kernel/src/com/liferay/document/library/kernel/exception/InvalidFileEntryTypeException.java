/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidFileEntryTypeException extends PortalException {

	public InvalidFileEntryTypeException() {
	}

	public InvalidFileEntryTypeException(String msg) {
		super(msg);
	}

	public InvalidFileEntryTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidFileEntryTypeException(Throwable cause) {
		super(cause);
	}

}