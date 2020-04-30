/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Jakub Liska
 */
public class DuplicateFileEntryTypeException extends PortalException {

	public DuplicateFileEntryTypeException() {
	}

	public DuplicateFileEntryTypeException(String msg) {
		super(msg);
	}

	public DuplicateFileEntryTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateFileEntryTypeException(Throwable cause) {
		super(cause);
	}

}