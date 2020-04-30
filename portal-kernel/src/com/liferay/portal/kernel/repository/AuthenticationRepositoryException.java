/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository;

/**
 * @author Adolfo Pérez
 */
public class AuthenticationRepositoryException extends RepositoryException {

	public AuthenticationRepositoryException() {
	}

	public AuthenticationRepositoryException(String msg) {
		super(msg);
	}

	public AuthenticationRepositoryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AuthenticationRepositoryException(Throwable cause) {
		super(cause);
	}

}