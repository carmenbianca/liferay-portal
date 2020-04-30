/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEntryUsageException extends NoSuchModelException {

	public NoSuchEntryUsageException() {
	}

	public NoSuchEntryUsageException(String msg) {
		super(msg);
	}

	public NoSuchEntryUsageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntryUsageException(Throwable cause) {
		super(cause);
	}

}