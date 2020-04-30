/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidSharingEntryUserException extends PortalException {

	public InvalidSharingEntryUserException() {
	}

	public InvalidSharingEntryUserException(String msg) {
		super(msg);
	}

	public InvalidSharingEntryUserException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidSharingEntryUserException(Throwable cause) {
		super(cause);
	}

}