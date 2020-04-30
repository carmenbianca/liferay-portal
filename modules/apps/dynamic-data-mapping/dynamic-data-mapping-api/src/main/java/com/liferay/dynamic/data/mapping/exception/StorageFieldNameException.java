/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class StorageFieldNameException extends StorageException {

	public StorageFieldNameException() {
	}

	public StorageFieldNameException(String msg) {
		super(msg);
	}

	public StorageFieldNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public StorageFieldNameException(Throwable cause) {
		super(cause);
	}

}