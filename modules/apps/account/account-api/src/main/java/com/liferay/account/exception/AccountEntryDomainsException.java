/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class AccountEntryDomainsException extends PortalException {

	public AccountEntryDomainsException() {
	}

	public AccountEntryDomainsException(String msg) {
		super(msg);
	}

	public AccountEntryDomainsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AccountEntryDomainsException(Throwable cause) {
		super(cause);
	}

}