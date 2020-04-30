/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEntryOrganizationRelException extends NoSuchModelException {

	public NoSuchEntryOrganizationRelException() {
	}

	public NoSuchEntryOrganizationRelException(String msg) {
		super(msg);
	}

	public NoSuchEntryOrganizationRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntryOrganizationRelException(Throwable cause) {
		super(cause);
	}

}