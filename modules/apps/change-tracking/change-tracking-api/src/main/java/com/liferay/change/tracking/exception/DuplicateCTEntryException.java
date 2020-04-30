/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateCTEntryException extends PortalException {

	public DuplicateCTEntryException() {
	}

	public DuplicateCTEntryException(String msg) {
		super(msg);
	}

	public DuplicateCTEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateCTEntryException(Throwable cause) {
		super(cause);
	}

}