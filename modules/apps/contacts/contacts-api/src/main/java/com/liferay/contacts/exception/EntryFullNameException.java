/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryFullNameException extends PortalException {

	public EntryFullNameException() {
	}

	public EntryFullNameException(String msg) {
		super(msg);
	}

	public EntryFullNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryFullNameException(Throwable cause) {
		super(cause);
	}

}