/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEntrySegmentsEntryRelException extends NoSuchModelException {

	public NoSuchEntrySegmentsEntryRelException() {
	}

	public NoSuchEntrySegmentsEntryRelException(String msg) {
		super(msg);
	}

	public NoSuchEntrySegmentsEntryRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntrySegmentsEntryRelException(Throwable cause) {
		super(cause);
	}

}