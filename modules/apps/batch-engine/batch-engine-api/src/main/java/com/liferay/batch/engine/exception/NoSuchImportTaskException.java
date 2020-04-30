/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Shuyang Zhou
 */
public class NoSuchImportTaskException extends NoSuchModelException {

	public NoSuchImportTaskException() {
	}

	public NoSuchImportTaskException(String msg) {
		super(msg);
	}

	public NoSuchImportTaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchImportTaskException(Throwable cause) {
		super(cause);
	}

}