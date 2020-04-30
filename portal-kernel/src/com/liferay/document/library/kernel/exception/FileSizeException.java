/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FileSizeException extends PortalException {

	public FileSizeException() {
	}

	public FileSizeException(String msg) {
		super(msg);
	}

	public FileSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileSizeException(Throwable cause) {
		super(cause);
	}

}