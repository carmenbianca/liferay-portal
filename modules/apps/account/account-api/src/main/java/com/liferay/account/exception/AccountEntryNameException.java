/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class AccountEntryNameException extends PortalException {

	public AccountEntryNameException() {
	}

	public AccountEntryNameException(String msg) {
		super(msg);
	}

	public AccountEntryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AccountEntryNameException(Throwable cause) {
		super(cause);
	}

}