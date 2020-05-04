/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateAccountEntryIdException extends PortalException {

	public DuplicateAccountEntryIdException() {
	}

	public DuplicateAccountEntryIdException(String msg) {
		super(msg);
	}

	public DuplicateAccountEntryIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateAccountEntryIdException(Throwable cause) {
		super(cause);
	}

}