/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Alexander Chow
 */
public class RepositoryException extends SystemException {

	public RepositoryException() {
	}

	public RepositoryException(String msg) {
		super(msg);
	}

	public RepositoryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RepositoryException(Throwable cause) {
		super(cause);
	}

}