/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredFileEntryTypeException extends PortalException {

	public RequiredFileEntryTypeException() {
	}

	public RequiredFileEntryTypeException(String msg) {
		super(msg);
	}

	public RequiredFileEntryTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredFileEntryTypeException(Throwable cause) {
		super(cause);
	}

}