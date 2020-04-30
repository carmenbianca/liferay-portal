/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEntryUserRelException extends NoSuchModelException {

	public NoSuchEntryUserRelException() {
	}

	public NoSuchEntryUserRelException(String msg) {
		super(msg);
	}

	public NoSuchEntryUserRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntryUserRelException(Throwable cause) {
		super(cause);
	}

}