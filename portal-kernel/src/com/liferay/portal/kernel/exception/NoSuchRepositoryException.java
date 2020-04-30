/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRepositoryException extends NoSuchModelException {

	public NoSuchRepositoryException() {
	}

	public NoSuchRepositoryException(String msg) {
		super(msg);
	}

	public NoSuchRepositoryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRepositoryException(Throwable cause) {
		super(cause);
	}

}