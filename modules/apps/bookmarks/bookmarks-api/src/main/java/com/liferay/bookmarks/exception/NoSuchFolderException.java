/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFolderException extends NoSuchModelException {

	public NoSuchFolderException() {
	}

	public NoSuchFolderException(String msg) {
		super(msg);
	}

	public NoSuchFolderException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFolderException(Throwable cause) {
		super(cause);
	}

}