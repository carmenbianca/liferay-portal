/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntrySmallImageNameException extends PortalException {

	public EntrySmallImageNameException() {
	}

	public EntrySmallImageNameException(String msg) {
		super(msg);
	}

	public EntrySmallImageNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntrySmallImageNameException(Throwable cause) {
		super(cause);
	}

}