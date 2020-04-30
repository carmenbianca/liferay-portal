/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFolderNameException extends PortalException {

	public DuplicateFolderNameException() {
	}

	public DuplicateFolderNameException(String msg) {
		super(msg);
	}

	public DuplicateFolderNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateFolderNameException(Throwable cause) {
		super(cause);
	}

}