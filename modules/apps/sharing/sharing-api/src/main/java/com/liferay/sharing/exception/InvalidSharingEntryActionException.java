/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidSharingEntryActionException extends PortalException {

	public InvalidSharingEntryActionException() {
	}

	public InvalidSharingEntryActionException(String msg) {
		super(msg);
	}

	public InvalidSharingEntryActionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidSharingEntryActionException(Throwable cause) {
		super(cause);
	}

}