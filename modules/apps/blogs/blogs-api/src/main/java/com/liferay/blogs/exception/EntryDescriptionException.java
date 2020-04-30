/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryDescriptionException extends PortalException {

	public EntryDescriptionException() {
	}

	public EntryDescriptionException(String msg) {
		super(msg);
	}

	public EntryDescriptionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryDescriptionException(Throwable cause) {
		super(cause);
	}

}