/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFileEntryException extends PortalException {

	public DuplicateFileEntryException() {
	}

	public DuplicateFileEntryException(String msg) {
		super(msg);
	}

	public DuplicateFileEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateFileEntryException(Throwable cause) {
		super(cause);
	}

}