/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidRepositoryException extends PortalException {

	public InvalidRepositoryException() {
	}

	public InvalidRepositoryException(String msg) {
		super(msg);
	}

	public InvalidRepositoryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidRepositoryException(Throwable cause) {
		super(cause);
	}

}