/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFormInstanceRecordException extends NoSuchModelException {

	public NoSuchFormInstanceRecordException() {
	}

	public NoSuchFormInstanceRecordException(String msg) {
		super(msg);
	}

	public NoSuchFormInstanceRecordException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFormInstanceRecordException(Throwable cause) {
		super(cause);
	}

}