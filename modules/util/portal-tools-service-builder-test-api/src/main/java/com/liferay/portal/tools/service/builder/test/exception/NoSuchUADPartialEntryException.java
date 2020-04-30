/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUADPartialEntryException extends NoSuchModelException {

	public NoSuchUADPartialEntryException() {
	}

	public NoSuchUADPartialEntryException(String msg) {
		super(msg);
	}

	public NoSuchUADPartialEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUADPartialEntryException(Throwable cause) {
		super(cause);
	}

}