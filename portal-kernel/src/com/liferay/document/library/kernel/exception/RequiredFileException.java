/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredFileException extends PortalException {

	public RequiredFileException() {
	}

	public RequiredFileException(String msg) {
		super(msg);
	}

	public RequiredFileException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredFileException(Throwable cause) {
		super(cause);
	}

}