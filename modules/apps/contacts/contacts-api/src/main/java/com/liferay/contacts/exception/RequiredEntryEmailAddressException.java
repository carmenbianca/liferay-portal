/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredEntryEmailAddressException extends PortalException {

	public RequiredEntryEmailAddressException() {
	}

	public RequiredEntryEmailAddressException(String msg) {
		super(msg);
	}

	public RequiredEntryEmailAddressException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredEntryEmailAddressException(Throwable cause) {
		super(cause);
	}

}