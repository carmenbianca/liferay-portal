/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryUrlTitleException extends PortalException {

	public EntryUrlTitleException() {
	}

	public EntryUrlTitleException(String msg) {
		super(msg);
	}

	public EntryUrlTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryUrlTitleException(Throwable cause) {
		super(cause);
	}

}