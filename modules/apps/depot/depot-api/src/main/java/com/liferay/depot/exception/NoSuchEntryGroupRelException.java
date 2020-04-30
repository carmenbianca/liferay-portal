/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEntryGroupRelException extends NoSuchModelException {

	public NoSuchEntryGroupRelException() {
	}

	public NoSuchEntryGroupRelException(String msg) {
		super(msg);
	}

	public NoSuchEntryGroupRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntryGroupRelException(Throwable cause) {
		super(cause);
	}

}