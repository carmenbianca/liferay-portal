/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.microblogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class UnsupportedMicroblogsEntryException extends PortalException {

	public UnsupportedMicroblogsEntryException() {
	}

	public UnsupportedMicroblogsEntryException(String msg) {
		super(msg);
	}

	public UnsupportedMicroblogsEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UnsupportedMicroblogsEntryException(Throwable cause) {
		super(cause);
	}

}