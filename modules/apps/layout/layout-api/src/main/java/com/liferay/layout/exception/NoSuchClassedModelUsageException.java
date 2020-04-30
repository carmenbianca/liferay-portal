/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchClassedModelUsageException extends NoSuchModelException {

	public NoSuchClassedModelUsageException() {
	}

	public NoSuchClassedModelUsageException(String msg) {
		super(msg);
	}

	public NoSuchClassedModelUsageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchClassedModelUsageException(Throwable cause) {
		super(cause);
	}

}