/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FolderNameException extends PortalException {

	public FolderNameException() {
	}

	public FolderNameException(String msg) {
		super(msg);
	}

	public FolderNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FolderNameException(Throwable cause) {
		super(cause);
	}

}