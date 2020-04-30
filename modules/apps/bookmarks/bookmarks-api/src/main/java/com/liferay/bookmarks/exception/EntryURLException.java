/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryURLException extends PortalException {

	public EntryURLException() {
	}

	public EntryURLException(String msg) {
		super(msg);
	}

	public EntryURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryURLException(Throwable cause) {
		super(cause);
	}

}