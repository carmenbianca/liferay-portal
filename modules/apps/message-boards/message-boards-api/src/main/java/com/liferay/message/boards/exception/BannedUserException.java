/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class BannedUserException extends PortalException {

	public BannedUserException() {
	}

	public BannedUserException(String msg) {
		super(msg);
	}

	public BannedUserException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BannedUserException(Throwable cause) {
		super(cause);
	}

}