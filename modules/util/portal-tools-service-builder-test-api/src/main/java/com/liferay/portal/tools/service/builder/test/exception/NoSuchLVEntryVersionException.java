/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLVEntryVersionException extends NoSuchModelException {

	public NoSuchLVEntryVersionException() {
	}

	public NoSuchLVEntryVersionException(String msg) {
		super(msg);
	}

	public NoSuchLVEntryVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLVEntryVersionException(Throwable cause) {
		super(cause);
	}

}