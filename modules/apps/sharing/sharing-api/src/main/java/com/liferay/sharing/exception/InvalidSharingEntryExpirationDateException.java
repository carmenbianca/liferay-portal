/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidSharingEntryExpirationDateException
	extends PortalException {

	public InvalidSharingEntryExpirationDateException() {
	}

	public InvalidSharingEntryExpirationDateException(String msg) {
		super(msg);
	}

	public InvalidSharingEntryExpirationDateException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public InvalidSharingEntryExpirationDateException(Throwable cause) {
		super(cause);
	}

}