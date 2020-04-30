/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryEmailAddressException extends PortalException {

	public EntryEmailAddressException() {
	}

	public EntryEmailAddressException(String msg) {
		super(msg);
	}

	public EntryEmailAddressException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryEmailAddressException(Throwable cause) {
		super(cause);
	}

}