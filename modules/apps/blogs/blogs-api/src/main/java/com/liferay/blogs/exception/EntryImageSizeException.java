/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryImageSizeException extends PortalException {

	public EntryImageSizeException() {
	}

	public EntryImageSizeException(String msg) {
		super(msg);
	}

	public EntryImageSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryImageSizeException(Throwable cause) {
		super(cause);
	}

}