/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateGoogleUserIdException extends PortalException {

	public DuplicateGoogleUserIdException() {
	}

	public DuplicateGoogleUserIdException(String msg) {
		super(msg);
	}

	public DuplicateGoogleUserIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateGoogleUserIdException(Throwable cause) {
		super(cause);
	}

}