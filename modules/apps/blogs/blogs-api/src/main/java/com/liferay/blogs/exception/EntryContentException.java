/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryContentException extends PortalException {

	public EntryContentException() {
	}

	public EntryContentException(String msg) {
		super(msg);
	}

	public EntryContentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryContentException(Throwable cause) {
		super(cause);
	}

}