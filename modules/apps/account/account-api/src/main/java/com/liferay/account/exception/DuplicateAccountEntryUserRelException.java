/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateAccountEntryUserRelException extends PortalException {

	public DuplicateAccountEntryUserRelException() {
	}

	public DuplicateAccountEntryUserRelException(String msg) {
		super(msg);
	}

	public DuplicateAccountEntryUserRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateAccountEntryUserRelException(Throwable cause) {
		super(cause);
	}

}