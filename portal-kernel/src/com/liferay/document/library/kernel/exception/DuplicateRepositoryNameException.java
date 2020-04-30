/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateRepositoryNameException extends PortalException {

	public DuplicateRepositoryNameException() {
	}

	public DuplicateRepositoryNameException(String msg) {
		super(msg);
	}

	public DuplicateRepositoryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateRepositoryNameException(Throwable cause) {
		super(cause);
	}

}