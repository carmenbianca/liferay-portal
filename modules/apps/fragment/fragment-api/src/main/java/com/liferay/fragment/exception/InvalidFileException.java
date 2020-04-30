/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidFileException extends PortalException {

	public InvalidFileException() {
	}

	public InvalidFileException(String msg) {
		super(msg);
	}

	public InvalidFileException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidFileException(Throwable cause) {
		super(cause);
	}

}