/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Shuyang Zhou
 */
public class NoSuchExportTaskException extends NoSuchModelException {

	public NoSuchExportTaskException() {
	}

	public NoSuchExportTaskException(String msg) {
		super(msg);
	}

	public NoSuchExportTaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchExportTaskException(Throwable cause) {
		super(cause);
	}

}