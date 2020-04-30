/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateSharingEntryException extends PortalException {

	public DuplicateSharingEntryException() {
	}

	public DuplicateSharingEntryException(String msg) {
		super(msg);
	}

	public DuplicateSharingEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateSharingEntryException(Throwable cause) {
		super(cause);
	}

}