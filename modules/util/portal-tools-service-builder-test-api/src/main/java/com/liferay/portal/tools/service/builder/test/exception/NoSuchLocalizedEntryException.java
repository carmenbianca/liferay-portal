/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLocalizedEntryException extends NoSuchModelException {

	public NoSuchLocalizedEntryException() {
	}

	public NoSuchLocalizedEntryException(String msg) {
		super(msg);
	}

	public NoSuchLocalizedEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLocalizedEntryException(Throwable cause) {
		super(cause);
	}

}