/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchVersionedEntryException extends NoSuchModelException {

	public NoSuchVersionedEntryException() {
	}

	public NoSuchVersionedEntryException(String msg) {
		super(msg);
	}

	public NoSuchVersionedEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchVersionedEntryException(Throwable cause) {
		super(cause);
	}

}