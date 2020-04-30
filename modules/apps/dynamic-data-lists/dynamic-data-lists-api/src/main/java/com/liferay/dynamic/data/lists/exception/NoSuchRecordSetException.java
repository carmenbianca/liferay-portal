/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * Thrown when the system is unable to find a required DDL Record Set.
 *
 * @author Brian Wing Shun Chan
 */
public class NoSuchRecordSetException extends NoSuchModelException {

	public NoSuchRecordSetException() {
	}

	public NoSuchRecordSetException(String msg) {
		super(msg);
	}

	public NoSuchRecordSetException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRecordSetException(Throwable cause) {
		super(cause);
	}

}