/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateAccountEntryOrganizationRelException
	extends PortalException {

	public DuplicateAccountEntryOrganizationRelException() {
	}

	public DuplicateAccountEntryOrganizationRelException(String msg) {
		super(msg);
	}

	public DuplicateAccountEntryOrganizationRelException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateAccountEntryOrganizationRelException(Throwable cause) {
		super(cause);
	}

}