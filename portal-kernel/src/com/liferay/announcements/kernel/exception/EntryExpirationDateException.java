/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryExpirationDateException extends PortalException {

	public EntryExpirationDateException() {
	}

	public EntryExpirationDateException(String msg) {
		super(msg);
	}

	public EntryExpirationDateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryExpirationDateException(Throwable cause) {
		super(cause);
	}

}