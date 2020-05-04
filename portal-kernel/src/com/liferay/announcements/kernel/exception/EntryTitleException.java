/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryTitleException extends PortalException {

	public EntryTitleException() {
	}

	public EntryTitleException(String msg) {
		super(msg);
	}

	public EntryTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryTitleException(Throwable cause) {
		super(cause);
	}

}