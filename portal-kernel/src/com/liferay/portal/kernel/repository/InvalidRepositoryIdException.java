/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository;

/**
 * @author Alexander Chow
 */
public class InvalidRepositoryIdException extends RepositoryException {

	public InvalidRepositoryIdException() {
	}

	public InvalidRepositoryIdException(String msg) {
		super(msg);
	}

	public InvalidRepositoryIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidRepositoryIdException(Throwable cause) {
		super(cause);
	}

}