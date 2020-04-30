/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRecordSetVersionException extends NoSuchModelException {

	public NoSuchRecordSetVersionException() {
	}

	public NoSuchRecordSetVersionException(String msg) {
		super(msg);
	}

	public NoSuchRecordSetVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRecordSetVersionException(Throwable cause) {
		super(cause);
	}

}