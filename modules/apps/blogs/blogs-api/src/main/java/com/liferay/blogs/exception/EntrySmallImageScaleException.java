/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntrySmallImageScaleException extends PortalException {

	public EntrySmallImageScaleException() {
	}

	public EntrySmallImageScaleException(String msg) {
		super(msg);
	}

	public EntrySmallImageScaleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntrySmallImageScaleException(Throwable cause) {
		super(cause);
	}

}