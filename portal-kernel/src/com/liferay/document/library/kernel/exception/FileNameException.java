/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FileNameException extends PortalException {

	public FileNameException() {
	}

	public FileNameException(String msg) {
		super(msg);
	}

	public FileNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileNameException(Throwable cause) {
		super(cause);
	}

}